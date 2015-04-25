package project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import project.dao.IResDao;
import project.model.Pager;
import project.model.ProjectException;
import project.model.Res;

@Service("resService")
public class ResService implements IResService {

	private IResDao resDao;
	public IResDao getResDao() {
		return resDao;
	}

	@Resource
	public void setResDao(IResDao resDao) {
		this.resDao = resDao;
	}

	@Override
	public void add(Res res) {
		Res u = resDao.loadByResname(res.getRname());
		if(u!=null) throw new ProjectException("要添加的任务名称已经存在");
		resDao.add(res);
	}

	@Override
	public void update(Res res) {
		resDao.update(res);
	}

	@Override
	public void delete(int id) {
		resDao.delete(id);
	}

	@Override
	public Res load(int id) {
		return resDao.load(id);
	}

	@Override
	public List<Res> listByUid(int uid) {
		return resDao.listByUid(uid);
	}

	@Override
	public Pager<Res> findByUid(int uid) {
		return resDao.findByUid(uid);
	}


}
