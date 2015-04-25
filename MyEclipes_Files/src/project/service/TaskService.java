package project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.dao.IProjectDao;
import project.dao.ITaskDao;
import project.model.Pager;
import project.model.Project;
import project.model.ProjectException;
import project.model.Task;

@Service("taskService")
public class TaskService implements ITaskService {

	private ITaskDao taskDao;
	public ITaskDao getTaskDao() {
		return taskDao;
	}

	@Resource
	public void setTaskDao(ITaskDao taskDao) {
		this.taskDao = taskDao;
	}

	@Override
	public void add(Task task) {
		Task u = taskDao.loadByTaskname(task.getTname());
		if(u!=null) throw new ProjectException("要添加的任务名称已经存在");
		taskDao.add(task);
	}

	@Override
	public void update(Task task) {
		taskDao.update(task);
	}

	@Override
	public void delete(int id) {
		taskDao.delete(id);
	}

	@Override
	public Task load(int id) {
		return taskDao.load(id);
	}

	@Override
	public List<Task> listByPid(int pid) {
		return taskDao.listByPid(pid);
	}

	@Override
	public Pager<Task> findByPid(int pid) {
		return taskDao.findByPid(pid);
	}


}
