package project.service;

import java.util.List;

import project.model.Pager;
import project.model.Res;

public interface IResService {
	public void add(Res res);
	public void update(Res res);
	public void delete(int id);
	public Res load(int id);
	public List<Res> listByUid(int uid);
	public Pager<Res> findByUid(int uid);
//	public Project login(String projectname,String password);
}
