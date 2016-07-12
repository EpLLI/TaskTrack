package test.z.dao.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.z.Exception.DaoException;

import test.z.dao.dao.TaskDao;
import test.z.pojos.Project;
import test.z.pojos.Task;

@Repository()
public class TaskDaoImpl extends BaseDao<Task> implements TaskDao {

	@Autowired
	public TaskDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	private Logger log = Logger.getLogger(ManDaoImpl.class);
	@Override
	public void saveOrUpdate(Task task) throws DaoException {
		try {
			getSession().saveOrUpdate(task);
			getSession().update(task);
			getSession().flush();
		} catch (HibernateException e) {

			log.error("Error saveorUpdate in Dao" + e);
			throw new DaoException(e);
		}
		
		
	}

	@Override
	public List<Task> getAllTask() throws DaoException {
		List<Task> result = null;
		try {

			String hql = "FROM Task";
			Query query = getSession().createQuery(hql);
			result = query.list();
		} catch (HibernateException e) {

			log.error("Error getAllCieff in Dao" + e);
			throw new DaoException(e);
		}
		return result;
	
	}

	@Override
	public void addDeveloperTask(Task task) throws DaoException {

		try {

			String hql = "UPDATE Task set Developer=:developer " + "WHERE name=:name";
			Query query = getSession().createSQLQuery(hql);
			query.setParameter("developer", task.getDeveloper());
			query.setParameter("name", task.getName());

			query.executeUpdate();
			getSession().flush();
		} catch (HibernateException e) {
			log.error("Error updateDev  in Dao" + e);
			throw new DaoException(e);
		}

	
	}

	@Override
	public Task getTask(String name) throws DaoException {
		Task task = null;
		try {
			String hql = "select p from Task p where p.name = :name";
			Query query = getSession().createQuery(hql);
			query.setParameter("name", name);
			task = (Task) query.uniqueResult();
		} catch (HibernateException e) {
			log.error("Error findByUserName in Dao" + e);
			throw new DaoException(e);

		}
		return task;
	}

	@Override
	public boolean updateTask(Task task) throws DaoException {
		boolean flag = false;
		try {

			String hql = "UPDATE Task set status=:status " + "WHERE name=:name";
			Query query = getSession().createSQLQuery(hql);
			query.setParameter("status", task.getStatus());
			query.setParameter("name", task.getName());

			query.executeUpdate();
			getSession().flush();
		} catch (HibernateException e) {
			log.error("Error updateDev  in Dao" + e);
			throw new DaoException(e);
		}

		return flag;
	}

}
