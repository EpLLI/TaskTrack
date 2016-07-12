package test.z.service;

import java.util.List;

import test.z.Exception.DaoException;
import test.z.pojos.User;
import test.z.serviceException.ServiceException;

public interface IAdminService extends Services<User>{
	 void addUser(User user) throws ServiceException;
	 public List<User> getAllUser()throws ServiceException;
	 void delete(int id) throws ServiceException ;
	 public void updateDev(User user) throws ServiceException;
	 public List<User> getAllDev() throws ServiceException;
}
