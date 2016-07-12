package test.z.dao.daoimpl;

import java.lang.reflect.ParameterizedType;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.z.Exception.DaoException;
import test.z.dao.dao.Dao;


@Repository()
public class BaseDao<T> implements Dao<T> {

	private static Logger log = Logger.getLogger(BaseDao.class);

	SessionFactory sessionFactory;
	@Autowired
	public BaseDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public T getById(Long id) throws DaoException {
		log.info("Get class by id:" + id);
		T t = null;
		try {
			Class<T> res = getPersistentClass();
			t = (T) getSession().get(res, id);
			log.info("get clazz:" + t);
		} catch (HibernateException e) {
			log.error("Error get " + getPersistentClass() + " in Dao" + e);
			throw new DaoException(e);
		}
		return t;

	}

	private Class getPersistentClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * adds Model in database
	 */
	@Override
	public void add(T model) throws DaoException {
		try {
			getSession().saveOrUpdate(model);
			getSession().update(model);

			log.info("saveOrUpdate(t):" + model);
			log.info("Save or update (commit):" + model);
		} catch (HibernateException e) {
			log.error("Error save or update" + model + " in Dao" + e);
			throw new DaoException(e);
		}
	}

	/**
	 * @throws DaoException
	 * 
	 */
	@Override
	public void update(T model) throws DaoException {
		try {
			getSession().update(model);
			log.info("saveOrUpdate(t):" + model);
			log.info("Save or update (commit):" + model);
		} catch (HibernateException e) {
			log.error("Error save or update" + model + " in Dao" + e);
			throw new DaoException(e);
		}
	}

	/**
	 * remove Model by id
	 */
	@Override
	public void remove(Integer id) throws DaoException {
		try {
			T t = (T) getSession().get(getPersistentClass(), id);
			getSession().delete(t);
			log.info("Delete:" + id);
		} catch (HibernateException e) {
			log.error("Error remove in Dao/remove" + e);
			throw new DaoException(e);
		}

	}

	/**
	 * remove Model by model
	 */
	@Override
	public void remove(T model) throws DaoException {
		try {
			getSession().delete(model);
			log.info("Delete:" + model);
		} catch (HibernateException e) {
			log.error("Error save or update" + model + "in Dao" + e);
			throw new DaoException(e);
		}
	}

}
