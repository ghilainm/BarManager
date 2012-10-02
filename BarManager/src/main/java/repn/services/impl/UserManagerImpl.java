package repn.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import repn.dao.UserDao;
import repn.model.User;
import repn.services.UserManager;
import repn.services.exception.UserAlreadyExistException;

@Transactional(isolation=Isolation.SERIALIZABLE)
@Service()
public class UserManagerImpl implements UserManager{
	
	@Autowired
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void save(User user) throws UserAlreadyExistException {
		if(findUserByLogin(user.getLogin()) != null)
			throw new UserAlreadyExistException();
		userDao.save(user);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void delete(User user) {
		userDao.delete(user);
	}

	public User findUserByLogin(String login) {
		return userDao.findUserByLogin(login);
	}

}