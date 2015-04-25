package project.service;

import java.util.List;

import project.model.Disres;
import project.model.Pager;

public interface IDisresService {
	public void add(Disres disres);
	public void update(Disres disres);
	public void delete(int id);
	public Disres load(int id);
	public List<Disres> list();
	public List<Disres> listByTid(int tid);
	public Pager<Disres> find();
//	public Project login(String projectname,String password);
}
