package test.z.service;

import test.z.pojos.User;
import test.z.serviceException.ServiceException;

public interface ILoginService {
	User findById(int id)throws ServiceException;

	User findByUserName(String username)throws ServiceException;
}
