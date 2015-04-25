package project.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import project.model.Pager;
import project.model.SystemContext;
import project.model.Res;

@Repository("resDao")
public class ResDao extends HibernateDaoSupport implements IResDao {
	
	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(Res res) {
		this.getHibernateTemplate().save(res);
	}

	@Override
	public void update(Res res) {
		this.getHibernateTemplate().update(res);
	}

	@Override
	public void delete(int id) {
		Res res = this.load(id);
		this.getHibernateTemplate().delete(res);
	}

	@Override
	public Res load(int id) {
		return this.getHibernateTemplate().load(Res.class, id);
	}

	/*@SuppressWarnings("unchecked")
	@Override
	public List<Res> listByTid(int tid) {
		return this.getSession().createQuery("from Res where pid=?").setParameter(0, tid).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Res> findByTid(int tid) {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from Res where pid=?").setParameter(0, tid);
		query.setFirstResult(offset).setMaxResults(size);
		List<Res> datas = query.list();
		Pager<Res> us = new Pager<Res>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
		long total = (Long)this.getSession()
					.createQuery("select count(*) from Res where pid=?").setParameter(0, tid)
					.uniqueResult();
		us.setTotal(total);
		return us;
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public List<Res> listByUid(int uid) {
		return this.getSession().createQuery("from Res where uid=?").setParameter(0, uid).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Res> findByUid(int uid) {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from Res where uid=?").setParameter(0, uid);
		query.setFirstResult(offset).setMaxResults(size);
		List<Res> datas = query.list();
		Pager<Res> us = new Pager<Res>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
		long total = (Long)this.getSession()
					.createQuery("select count(*) from Res").uniqueResult();
		us.setTotal(total);
		return us;
	}
	
	
	@Override
	public Res loadByResname(String Resname) {
		return (Res)this.getSession().createQuery("from Res where rname=?")
					.setParameter(0, Resname).uniqueResult();
	}

}
