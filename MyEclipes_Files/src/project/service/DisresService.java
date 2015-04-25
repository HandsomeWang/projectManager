package project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.dao.IDisresDao;
import project.dao.IProjectDao;
import project.model.Disres;
import project.model.Pager;
import project.model.Project;
import project.model.ProjectException;

@Service("disresService")
public class DisresService implements IDisresService {

	private IDisresDao disresDao;
	
	
	
	public IDisresDao getDisresDao() {
		return disresDao;
	}

	@Resource
	public void setDisresDao(IDisresDao disresDao) {
		this.disresDao = disresDao;
	}

	@Override
	public void add(Disres disres) {
//		Disres u = disresDao.loadByDisresname(disres.getPname());
//		if(u!=null) throw new ProjectException("要添加的项目名称已经存在");
		disresDao.add(disres);
	}

	@Override
	public void update(Disres disres) {
		disresDao.update(disres);
	}

	@Override
	public void delete(int id) {
		disresDao.delete(id);
	}

	@Override
	public Disres load(int id) {
		return disresDao.load(id);
	}

	@Override
	public List<Disres> list() {
		return disresDao.list();
	}
	@Override
	public List<Disres> listByTid(int tid) {
		return disresDao.listByTid(tid);
	}

	@Override
	public Pager<Disres> find() {
		return disresDao.find();
	}

//	@Override
//	public Disres login(String disresname, String password) {
//		Disres u = disresDao.loadByDisresname(disresname);
//		if(u==null) throw new DisresException("登录用户不存在");
//		if(!u.getPassword().equals(password)) throw new DisresException("用户密码不正确");
//		return u;
//	}

}
