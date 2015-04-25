package project.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import project.model.Pager;
import project.model.SystemContext;
import project.model.Task;

@Repository("taskDao")
public class TaskDao extends HibernateDaoSupport implements ITaskDao {
	
	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(Task task) {
		this.getHibernateTemplate().save(task);
	}

	@Override
	public void update(Task task) {
		this.getHibernateTemplate().update(task);
	}

	@Override
	public void delete(int id) {
		Task task = this.load(id);
		this.getHibernateTemplate().delete(task);
	}

	@Override
	public Task load(int id) {
		return this.getHibernateTemplate().load(Task.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> listByPid(int pid) {
		return this.getSession().createQuery("from Task where pid=?").setParameter(0, pid).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Task> findByPid(int pid) {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from Task where pid=?").setParameter(0, pid);
		query.setFirstResult(offset).setMaxResults(size);
		List<Task> datas = query.list();
		Pager<Task> us = new Pager<Task>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
		long total = (Long)this.getSession()
					.createQuery("select count(*) from Task where pid=?").setParameter(0, pid)
					.uniqueResult();
		us.setTotal(total);
		return us;
	}

	@Override
	public Task loadByTaskname(String Taskname) {
		return (Task)this.getSession().createQuery("from Task where tname=?")
					.setParameter(0, Taskname).uniqueResult();
	}

}
