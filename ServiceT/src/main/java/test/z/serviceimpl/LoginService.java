package test.z.serviceimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.z.Exception.DaoException;
import test.z.dao.dao.UserDao;
import test.z.pojos.User;
import test.z.service.ILoginService;
import test.z.serviceException.ServiceException;

@Service
@Transactional
public class LoginService implements ILoginService{
	private static Logger log = Logger.getLogger(LoginService.class);
	@Autowired
	private UserDao dao;
	@Override
	public User findById(int id) throws ServiceException {
		try{
		return dao.getUserById(id);
		} catch (DaoException e) {
			log.error("Error in findById process --- " + e);
			throw new ServiceException(e);
		}
	}

	@Override
	public User findByUserName(String username) throws ServiceException {
		try{
		return dao.findByUserName(username);
	} catch (DaoException e) {
		log.error("Error in findByUserName process --- " + e);
		throw new ServiceException(e);
	}
	}

}
