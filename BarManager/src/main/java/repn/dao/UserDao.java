package repn.dao;

import repn.model.User;

public interface UserDao {
	
	void save(User user);
	void update(User user);
	void delete(User user);
	User findUserByLogin(String login);

}
