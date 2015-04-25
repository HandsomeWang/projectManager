package project.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import project.model.Pager;
import project.model.SystemContext;
import project.model.Disres;

@Repository("disresDao")
public class DisresDao extends HibernateDaoSupport implements IDisresDao {
	
	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	

	
	@Override
	public void add(Disres disres) {
		this.getHibernateTemplate().save(disres);
	}

	@Override
	public void update(Disres disres) {
		this.getHibernateTemplate().update(disres);
	}

	@Override
	public void delete(int id) {
		Disres disres = this.load(id);
		this.getHibernateTemplate().delete(disres);
	}

	@Override
	public Disres load(int id) {
		return this.getHibernateTemplate().load(Disres.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Disres> list() {
		return this.getSession().createQuery("from Disres").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Disres> listByTid(int tid) {
		return this.getSession().createQuery("from Disres where tid=?").setParameter(0, tid).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Disres> find() {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from Disres");
		query.setFirstResult(offset).setMaxResults(size);
		List<Disres> datas = query.list();
		Pager<Disres> us = new Pager<Disres>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
		long total = (Long)this.getSession()
					.createQuery("select count(*) from Disres")
					.uniqueResult();
		us.setTotal(total);
		return us;
	}

	@Override
	public Disres loadByDisresname(String disresname) {
		return (Disres)this.getSession().createQuery("from Disres where pname=?")
					.setParameter(0, disresname).uniqueResult();
	}

}
