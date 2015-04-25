package project.dao;

import java.util.List;

import project.model.Pager;
import project.model.Task;

public interface ITaskDao {
	public void add(Task task);
	public void update(Task task);
	public void delete(int id);
	public Task load(int id);
	public List<Task> listByPid(int pid);
	public Pager<Task> findByPid(int pid);
	public Task loadByTaskname(String taskname);
}
