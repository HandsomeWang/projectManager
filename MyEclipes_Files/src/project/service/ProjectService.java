package project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.dao.IProjectDao;
import project.model.Pager;
import project.model.Project;
import project.model.ProjectException;

@Service("projectService")
public class ProjectService implements IProjectService {

	private IProjectDao projectDao;
	
	
	
	public IProjectDao getProjectDao() {
		return projectDao;
	}

	@Resource
	public void setProjectDao(IProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Override
	public void add(Project project) {
		Project u = projectDao.loadByProjectname(project.getPname());
		if(u!=null) throw new ProjectException("要添加的项目名称已经存在");
		projectDao.add(project);
	}

	@Override
	public void update(Project project) {
		projectDao.update(project);
	}

	@Override
	public void delete(int id) {
		projectDao.delete(id);
	}

	@Override
	public Project load(int id) {
		return projectDao.load(id);
	}

	@Override
	public List<Project> listByUid(int uid) {
		return projectDao.listByUid(uid);
	}

	@Override
	public Pager<Project> findByUid(int uid) {
		return projectDao.findByUid(uid);
	}

//	@Override
//	public Project login(String projectname, String password) {
//		Project u = projectDao.loadByProjectname(projectname);
//		if(u==null) throw new ProjectException("登录用户不存在");
//		if(!u.getPassword().equals(password)) throw new ProjectException("用户密码不正确");
//		return u;
//	}

}
