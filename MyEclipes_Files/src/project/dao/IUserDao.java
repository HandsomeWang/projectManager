package project.dao;

import java.util.List;

import project.model.Pager;
import project.model.User;

public interface IUserDao {
	public void add(User user);
//	public void update(User user);
//	public void delete(int id);
	public User load(int id);
//	public List<User> list();
//	public Pager<User> find();
	public User loadByUsername(String username);
}
