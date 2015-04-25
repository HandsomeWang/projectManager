package project.service;
import project.model.User;

public interface IUserService {
	public void add(User user);
	public User load(int id);
	public User login(String projectname,String password);
}
