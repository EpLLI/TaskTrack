package test.z.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import test.z.Exception.DaoException;

import test.z.dao.dao.TaskDao;

import test.z.pojos.Task;

import test.z.service.ITaskService;
import test.z.serviceException.ServiceException;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TaskService extends BaseService<Task>implements ITaskService {
	private static Logger log = Logger.getLogger(ProjectService.class);

	@Autowired
	private TaskDao TaskDaoImpl;

	public TaskService() {
		
	}

	@Override
	public void addTask(Task task) throws ServiceException {
		try {
			TaskDaoImpl.saveOrUpdate(task);
		} catch (DaoException e) {
			log.error("Error in addRace process --- " + e);
			throw new ServiceException(e);
		}

	}

	@Override
	public List<Task> getAllTask() throws ServiceException {
		List<Task> task = null;

		try {
			task = TaskDaoImpl.getAllTask();
		} catch (DaoException e) {
			log.error("Error in getAllCoefficiet process --- " + e);
			throw new ServiceException(e);
		}
		return task;
	}

	@Override
	public void addDeveloperTask(Task task) throws ServiceException {
		try {
			TaskDaoImpl.addDeveloperTask(task);
		} catch (DaoException e) {
			log.error("Error in addCoefficient process --- " + e);
			throw new ServiceException(e);
		}
		
		
	}

	@Override
	public Task getTask(String name) throws ServiceException {
		try{
			return TaskDaoImpl.getTask(name);
		} catch (DaoException e) {
			log.error("Error in findByUserName process --- " + e);
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean updateTask(Task task) throws ServiceException {
		try {
			TaskDaoImpl.updateTask(task);
		} catch (DaoException e) {
			log.error("Error in addCoefficient process --- " + e);
			throw new ServiceException(e);
		}
		return false;
	}
}
