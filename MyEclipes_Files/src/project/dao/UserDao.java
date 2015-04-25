package project.dao;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import project.model.User;

@Repository("userDao")
public class UserDao extends HibernateDaoSupport implements IUserDao {
	
	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	@Override
	public void add(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public User load(int id) {
		return this.getHibernateTemplate().load(User.class, id);
	}

	/*@SuppusersWarnings("unchecked")
	@Override
	public List<User> listByTid(int tid) {
		return this.getSession().createQuery("from User where pid=?").setParameter(0, tid).list();
	}

	@SuppusersWarnings("unchecked")
	@Override
	public Pager<User> findByTid(int tid) {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from User where pid=?").setParameter(0, tid);
		query.setFirstUserult(offset).setMaxUserults(size);
		List<User> datas = query.list();
		Pager<User> us = new Pager<User>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
		long total = (Long)this.getSession()
					.createQuery("select count(*) from User where pid=?").setParameter(0, tid)
					.uniqueUserult();
		us.setTotal(total);
		return us;
	}*/
	
	
	@Override
	public User loadByUsername(String Username) {
		return (User)this.getSession().createQuery("from User where uname=?")
					.setParameter(0, Username).uniqueResult();
	}

}
