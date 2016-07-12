package test.z.dao.dao;

import java.util.List;

import test.z.Exception.DaoException;
import test.z.pojos.Project;
import test.z.pojos.Task;
import test.z.pojos.User;

public interface TaskDao extends Dao<Task> {
	void saveOrUpdate(Task task) throws DaoException;
	List<Task> getAllTask() throws DaoException;
	void addDeveloperTask(Task task) throws DaoException;
	Task getTask(String name) throws DaoException;
	boolean updateTask(Task task) throws DaoException;
}
