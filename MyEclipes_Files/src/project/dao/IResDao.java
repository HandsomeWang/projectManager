package project.dao;

import java.util.List;

import project.model.Pager;
import project.model.Res;

public interface IResDao {
	public void add(Res res);
	public void update(Res res);
	public void delete(int id);
	public Res load(int id);
	public List<Res> listByUid(int uid);
	public Pager<Res> findByUid(int uid);
	public Res loadByResname(String resname);
}
