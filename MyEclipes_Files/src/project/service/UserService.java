package project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.dao.IProjectDao;
import project.dao.IUserDao;
import project.model.Pager;
import project.model.Project;
import project.model.ProjectException;
import project.model.Task;
import project.model.User;
import project.model.UserException;

@Service("userService")
public class UserService implements IUserService {

	private IUserDao userDao;
	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		User u = userDao.loadByUsername(user.getUname());
		if(u!=null) throw new ProjectException("要添加的任务名称已经存在");
		userDao.add(user);
	}

	
	@Override
	public User load(int id) {
		return userDao.load(id);
	}

	public User login(String username, String password) {
		User u = userDao.loadByUsername(username);
		if(u==null) throw new UserException("登录用户不存在");
		if(!u.getUpwd().equals(password)) throw new UserException("用户密码不正确");
		return u;
	}


}
