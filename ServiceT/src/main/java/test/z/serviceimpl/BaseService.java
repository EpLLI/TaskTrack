package test.z.serviceimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import test.z.Exception.DaoException;
import test.z.dao.dao.Dao;
import test.z.service.Services;
import test.z.serviceException.ServiceException;



@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BaseService <T> implements Services<T> {

	private static Logger log = Logger.getLogger(BaseService.class);
	@Autowired 
	private Dao<T> baseDao;

	public BaseService() {
	}

	 
	public BaseService(Dao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public T getById(Long id) throws ServiceException {
		T t = null;
		try {
			t = baseDao.getById(id);
		} catch (DaoException e) {
			log.error("Error in getById process --- " + e);
			throw new ServiceException(e);
		}
		return t;
	}

	@Override
	public void add(T model) throws ServiceException {
		if (model != null) {
			try {
				baseDao.add(model);
			} catch (DaoException e) {
				log.error("Error in add process --- " + e);
				throw new ServiceException(e);
			}
		}
	}

	@Override
	public void update(T model) throws ServiceException {
		if (model != null) {
			try {
				baseDao.update(model);
			} catch (DaoException e) {
				log.error("Error in update process --- " + e);
				throw new ServiceException(e);
			}
		}
	}

	@Override
	public void remove(Integer id) throws ServiceException {
		if (id != null) {
			try {
				baseDao.remove(id);
			} catch (DaoException e) {
				log.error("Error in remove process --- " + e);
				throw new ServiceException(e);
			}
		}
	}

	@Override
	public void remove(T model) throws ServiceException {
		if (model != null) {
			try {
				baseDao.remove(model);
			} catch (DaoException e) {
				log.error("Error in remove process --- " + e);
				throw new ServiceException(e);
			}
		}

	}

}
