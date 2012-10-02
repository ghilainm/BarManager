package repn.services;

import repn.dao.UserDao;
import repn.model.User;
import repn.services.exception.UserAlreadyExistException;

public interface UserManager {
	public void setUserDao(UserDao userDao);

	public void save(User user) throws UserAlreadyExistException;

	public void update(User user);

	public void delete(User user);

	public User findUserByLogin(String login);
}
