package test.z.service;

import java.util.List;

import test.z.Exception.DaoException;
import test.z.pojos.Task;
import test.z.serviceException.ServiceException;

public interface ITaskService extends Services<Task>{
	 void addTask(Task task) throws ServiceException;
	 public List<Task> getAllTask()throws ServiceException;
	 void addDeveloperTask(Task task) throws ServiceException;
	 Task getTask(String name) throws ServiceException;
	 boolean updateTask(Task task) throws ServiceException;
}
