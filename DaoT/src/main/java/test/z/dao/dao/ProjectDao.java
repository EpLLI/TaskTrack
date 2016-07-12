package test.z.dao.dao;

import java.util.List;

import test.z.Exception.DaoException;
import test.z.pojos.Project;
import test.z.pojos.User;



public interface ProjectDao extends Dao<Project> {
	void saveOrUpdate(Project proj) throws DaoException;
	List<Project> getAllProject() throws DaoException;
	
	Project getProject(String name) throws DaoException;
}
