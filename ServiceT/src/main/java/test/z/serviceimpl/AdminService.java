package test.z.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.z.Exception.DaoException;

import test.z.dao.dao.ManDao;

import test.z.pojos.User;
import test.z.service.IAdminService;
import test.z.serviceException.ServiceException;

import org.springframework.transaction.annotation.Propagation;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AdminService extends BaseService<User>implements IAdminService {
	private static Logger log = Logger.getLogger(AdminService.class);

	@Autowired
	private ManDao manDaoImpl;

	public AdminService() {

	}

	@Override
	public void addUser(User user) throws ServiceException {
		try {
			manDaoImpl.saveOrUpdate(user);
		} catch (DaoException e) {
			log.error("Error in addRace process --- " + e);
			throw new ServiceException(e);
		}
	}

	@Override
	public List<User> getAllUser() throws ServiceException {
		List<User>  user = null;

		try {
			user = manDaoImpl.getAllUser();
		} catch (DaoException e) {
			log.error("Error in getAllCoefficiet process --- " + e);
			throw new ServiceException(e);
		}
		return user;
	}

	@Override
	public void delete(int id) throws ServiceException {
		try {
			
			manDaoImpl.delete(id);;
		} catch (DaoException e) {
			log.error("Error in addRace process --- " + e);
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void updateDev(User user) throws ServiceException {
		try {
			manDaoImpl.updateDev(user);
		} catch (DaoException e) {
			log.error("Error in addCoefficient process --- " + e);
			throw new ServiceException(e);
		}
		
	}

	@Override
	public List<User> getAllDev() throws ServiceException {
		List<User>  user = null;

		try {
			user = manDaoImpl.getAllDev();
		} catch (DaoException e) {
			log.error("Error in getAllCoefficiet process --- " + e);
			throw new ServiceException(e);
		}
		return user;
	}
	

}
