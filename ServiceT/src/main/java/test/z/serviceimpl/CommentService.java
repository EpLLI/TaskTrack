package test.z.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.z.Exception.DaoException;
import test.z.dao.dao.CommentDao;

import test.z.pojos.Comment;
import test.z.pojos.Project;
import test.z.service.ICommentService;
import test.z.serviceException.ServiceException;

@Repository()
public class CommentService extends BaseService<Comment>implements ICommentService {

	private static Logger log = Logger.getLogger(ProjectService.class);

	@Autowired
	private CommentDao CommentDaoImpl;

	public CommentService() {

	}

	@Override
	public void addComment(Comment comm) throws ServiceException {
		try {
			CommentDaoImpl.saveOrUpdate(comm);
		} catch (DaoException e) {
			log.error("Error in addRace process --- " + e);
			throw new ServiceException(e);
		}

	}

	@Override
	public List<Comment> getAllComment() throws ServiceException {
		List<Comment> comm = null;

		try {
			comm = CommentDaoImpl.getAllComment();
		} catch (DaoException e) {
			log.error("Error in getAllCoefficiet process --- " + e);
			throw new ServiceException(e);
		}
		return comm;
	}

	@Override
	public List<Comment> getCommentTask(String task) throws ServiceException {
		List<Comment> comm = null;

		try {
			comm = CommentDaoImpl.getCommentTask(task);
		} catch (DaoException e) {
			log.error("Error in getAllCoefficiet process --- " + e);
			throw new ServiceException(e);
		}
		return comm;
	}

	@Override
	public void delete(int id) throws ServiceException {
		try {
			CommentDaoImpl.delete(id);
			;
		} catch (DaoException e) {
			log.error("Error in addRace process --- " + e);
			throw new ServiceException(e);
		}

	}



	@Override
	public boolean updateComm(Comment comm) throws ServiceException {
		try {
			CommentDaoImpl.updateComm(comm);
		} catch (DaoException e) {
			log.error("Error in addCoefficient process --- " + e);
			throw new ServiceException(e);
		}
		return false;
	}

}
