package project.dao;

import java.util.List;

import project.model.Pager;
import project.model.Disres;

public interface IDisresDao {
	public void add(Disres disres);
	public void update(Disres disres);
	public void delete(int id);
	public Disres load(int id);
//	public List<Disres> listByTid(int tid);
	public List<Disres> list();
	public List<Disres> listByTid(int tid);
//	public Pager<Disres> findByTid(int tid);
	public Pager<Disres> find();
	public Disres loadByDisresname(String resname);
}
