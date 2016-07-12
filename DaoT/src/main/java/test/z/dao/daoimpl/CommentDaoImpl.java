package test.z.dao.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.z.Exception.DaoException;
import test.z.dao.dao.CommentDao;

import test.z.pojos.Comment;


@Repository()
public class CommentDaoImpl extends BaseDao<Comment> implements CommentDao{

	@Autowired
	public CommentDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	private Logger log = Logger.getLogger(ManDaoImpl.class);
	
	@Override
	public void saveOrUpdate(Comment comm) throws DaoException {
		try {
			getSession().saveOrUpdate(comm);
			getSession().update(comm);
			getSession().flush();
		} catch (HibernateException e) {

			log.error("Error saveorUpdate in Dao" + e);
			throw new DaoException(e);
		}
		
		
	}

	@Override
	public List<Comment> getAllComment() throws DaoException {
		List<Comment> result = null;
		try {

			String hql = "FROM Comment";
			Query query = getSession().createQuery(hql);
			result = query.list();
		} catch (HibernateException e) {

			log.error("Error getAllCieff in Dao" + e);
			throw new DaoException(e);
		}
		return result;
	
	}

	@Override
	public List<Comment> getCommentTask(String task) throws DaoException {
		List<Comment> result = null;
		try {

			String hql = "select p from Comment p where p.task = :task";
			
			Query query = getSession().createQuery(hql);
			query.setParameter("task", task);
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
			String hql = "Delete from Comment where  id=:id";
			Query query = getSession().createSQLQuery(hql);
			query.setParameter("id", id);
			getSession().flush();
		} catch (HibernateException e) {
			log.error("Error DELETE in Dao    " + e);
			throw new DaoException(e);
		}
		
	}

	@Override
	public boolean updateComm(Comment comm) throws DaoException {
		boolean flag = false;
		try {

			String hql = "UPDATE Comment set text=:text "+ "WHERE id=:id";
			Query query = getSession().createSQLQuery(hql);
			query.setParameter("text", comm.getText());
			query.setParameter("id", comm.getId());
			query.executeUpdate();
			getSession().flush();
		} catch (HibernateException e) {
			log.error("Error updateDev  in Dao" + e);
			throw new DaoException(e);
		}

		return flag;
	
	}

}
