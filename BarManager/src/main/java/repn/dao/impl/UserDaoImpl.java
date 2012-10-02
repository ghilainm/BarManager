package repn.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import repn.dao.UserDao;
import repn.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Resource
    private SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	@Override
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}

	@Override
	public void delete(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
	}

	@Override
	public User findUserByLogin(String login) {
		return null;
	}

}
