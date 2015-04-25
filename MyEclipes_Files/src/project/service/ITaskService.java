package project.service;

import java.util.List;

import project.model.Pager;
import project.model.Project;
import project.model.Task;

public interface ITaskService {
	public void add(Task task);
	public void update(Task task);
	public void delete(int id);
	public Task load(int id);
	public List<Task> listByPid(int pid);
	public Pager<Task> findByPid(int pid);
//	public Project login(String projectname,String password);
}
