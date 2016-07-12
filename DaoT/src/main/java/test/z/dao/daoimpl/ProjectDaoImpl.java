package test.z.dao.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.z.Exception.DaoException;
import test.z.dao.dao.ManDao;
import test.z.dao.dao.ProjectDao;
import test.z.pojos.Project;
import test.z.pojos.User;

@Repository()
public class ProjectDaoImpl extends BaseDao<Project> implements ProjectDao{
	@Autowired
	public ProjectDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	private Logger log = Logger.getLogger(ProjectDaoImpl.class);
	@Override
	public void saveOrUpdate(Project proj) throws DaoException {
		try {
			getSession().saveOrUpdate(proj);
			getSession().update(proj);
			getSession().flush();
		} catch (HibernateException e) {

			log.error("Error saveorUpdate in Dao" + e);
			throw new DaoException(e);
		}
		
	}

	@Override
	public List<Project> getAllProject() throws DaoException {
		List<Project> result = null;
		try {

			String hql = "FROM Project";
			Query query = getSession().createQuery(hql);
			result = query.list();
		} catch (HibernateException e) {

			log.error("Error getAllProject in Dao" + e);
			throw new DaoException(e);
		}
		return result;
	}

	@Override
	public Project getProject(String name) throws DaoException {
		Project project = null;
		try {
			String hql = "select p from Project p where p.name = :name";
			Query query = getSession().createQuery(hql);
			query.setParameter("name", name);
			project = (Project) query.uniqueResult();
		} catch (HibernateException e) {
			log.error("Error findByUserName in Dao" + e);
			throw new DaoException(e);

		}
		return project;
	}
}
