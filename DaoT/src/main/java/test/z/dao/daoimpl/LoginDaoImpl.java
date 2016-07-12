package test.z.dao.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.z.Exception.DaoException;
import test.z.dao.dao.UserDao;
import test.z.pojos.User;

@Repository
public class LoginDaoImpl extends BaseDao<User>implements UserDao {
	private Logger log = Logger.getLogger(LoginDaoImpl.class);

	@Autowired
	public LoginDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public User getUserById(int id) throws DaoException {
		User user = null;
		try {
			String hql = "select u from User u where u.id = :id";
			Query query = getSession().createQuery(hql);
			query.setParameter("id", id);
			user = (User) query.uniqueResult();
		} catch (HibernateException e) {
			log.error("Error getUserById in Dao" + e);
			throw new DaoException(e);

		}
		return user;
	}

	@Override
	public User findByUserName(String username) throws DaoException {
		User user = null;
		try {
			String hql = "select u from User u where u.username = :username";
			Query query = getSession().createQuery(hql);
			query.setParameter("username", username);
			user = (User) query.uniqueResult();
		} catch (HibernateException e) {
			log.error("Error findByUserName in Dao" + e);
			throw new DaoException(e);

		}
		return user;
	}

}
