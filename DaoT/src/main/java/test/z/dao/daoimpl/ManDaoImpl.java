package test.z.dao.daoimpl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import test.z.Exception.DaoException;
import test.z.dao.dao.ManDao;
import test.z.pojos.User;



@Repository()
public class ManDaoImpl<T> extends BaseDao<User>implements ManDao {
	
	@Autowired
	public ManDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	private Logger log = Logger.getLogger(ManDaoImpl.class);
	@Override
	public void saveOrUpdate(User user) throws DaoException {
		try {
			getSession().saveOrUpdate(user);
			getSession().update(user);
			getSession().flush();
		} catch (HibernateException e) {

			log.error("Error saveorUpdate in Dao" + e);
			throw new DaoException(e);
		}
		
	}
	@Override
	public List<User> getAllUser() throws DaoException {
		List<User> result = null;
		try {

			String hql = "FROM User";
			Query query = getSession().createQuery(hql);
			result = query.list();
		} catch (HibernateException e) {

			log.error("Error getAllCieff in Dao" + e);
			throw new DaoException(e);
		}
		return result;

	}

	@Override
	public void delete(int id) throws DaoException {
		try {
			String hql = "Delete from User where  id=:id";
			Query query = getSession().createSQLQuery(hql);
			query.setParameter("id", id);
			getSession().flush();
		} catch (HibernateException e) {
			log.error("Error DELETE in Dao    " + e);
			throw new DaoException(e);
		}
		
	}
	@Override
	public boolean updateDev(User user) throws DaoException {
		boolean flag = false;
		try {

			String hql = "UPDATE User set role=:role " + "WHERE id=:id";
			Query query = getSession().createSQLQuery(hql);
			query.setParameter("role", user.getRole());
			query.setParameter("id", user.getId());

			query.executeUpdate();
			getSession().flush();
		} catch (HibernateException e) {
			log.error("Error updateDev  in Dao" + e);
			throw new DaoException(e);
		}

		return flag;
		
	}
	@Override
	public List<User> getAllDev() throws DaoException {
		List<User> result = null;
		try {

			String hql = "FROM User where role in('dev')";
			Query query = getSession().createQuery(hql);
			result = query.list();
		} catch (HibernateException e) {

			log.error("Error getAllCieff in Dao" + e);
			throw new DaoException(e);
		}
		return result;
	}

}
