package test.z.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.z.Exception.DaoException;


import test.z.dao.dao.ProjectDao;
import test.z.pojos.Project;
import test.z.pojos.User;
import test.z.service.IProjectService;
import test.z.serviceException.ServiceException;

import org.springframework.transaction.annotation.Propagation;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProjectService extends BaseService<Project>implements IProjectService {
	private static Logger log = Logger.getLogger(ProjectService.class);

	@Autowired
	private ProjectDao projectDaoImpl;

	public ProjectService() {

	}

	@Override
	public void addProject(Project proj) throws ServiceException {
		try {
			projectDaoImpl.saveOrUpdate(proj);
		} catch (DaoException e) {
			log.error("Error in addRace process --- " + e);
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Project> getAllProject() throws ServiceException {
		List<Project> proj = null;

		try {
			proj = projectDaoImpl.getAllProject();
		} catch (DaoException e) {
			log.error("Error in getAllCoefficiet process --- " + e);
			throw new ServiceException(e);
		}
		return proj;
	}
	@Override
	public Project getProject(String name) throws ServiceException {
		try{
		return projectDaoImpl.getProject(name);
	} catch (DaoException e) {
		log.error("Error in findByUserName process --- " + e);
		throw new ServiceException(e);
	}
	}

}
