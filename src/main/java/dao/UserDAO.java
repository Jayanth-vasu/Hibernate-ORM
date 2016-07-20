package dao;

import java.util.List;

import model.User;

public interface UserDAO {
	public List<User> list();
	public User get(String id);
	public void saveorupdate(User user);
	public void delete(String id);
}
