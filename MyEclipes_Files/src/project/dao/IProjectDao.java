package project.dao;

import java.util.List;

import project.model.Pager;
import project.model.Project;

public interface IProjectDao {
	public void add(Project project);
	public void update(Project project);
	public void delete(int id);
	public Project load(int id);
	public List<Project> listByUid(int uid);
	public Pager<Project> findByUid(int uid);
	public Project loadByProjectname(String projectname);
}
