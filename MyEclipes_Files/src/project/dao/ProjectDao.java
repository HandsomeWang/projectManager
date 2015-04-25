package project.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import project.model.Pager;
import project.model.SystemContext;
import project.model.Project;

@Repository("projectDao")
public class ProjectDao extends HibernateDaoSupport implements IProjectDao {
	
	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	

	
	@Override
	public void add(Project project) {
		this.getHibernateTemplate().save(project);
	}

	@Override
	public void update(Project project) {
		this.getHibernateTemplate().update(project);
	}

	@Override
	public void delete(int id) {
		Project project = this.load(id);
		this.getHibernateTemplate().delete(project);
	}

	@Override
	public Project load(int id) {
		return this.getHibernateTemplate().load(Project.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> listByUid(int uid) {
		return this.getSession().createQuery("from Project where uid=?").setParameter(0, uid).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Project> findByUid(int uid) {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from Project where uid=?").setParameter(0, uid);
		query.setFirstResult(offset).setMaxResults(size);
		List<Project> datas = query.list();
		Pager<Project> us = new Pager<Project>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
		long total = (Long)this.getSession()
					.createQuery("select count(*) from Project")
					.uniqueResult();
		us.setTotal(total);
		return us;
	}


	public Project loadByProjectname(String projectname) {
		return (Project)this.getSession().createQuery("from Project where pname=?")
					.setParameter(0, projectname).uniqueResult();
	}

}
