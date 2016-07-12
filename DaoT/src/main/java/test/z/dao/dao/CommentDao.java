package test.z.dao.dao;

import java.util.List;



import test.z.Exception.DaoException;
import test.z.pojos.Comment;



public interface CommentDao extends Dao<Comment> {
	void saveOrUpdate(Comment comm) throws DaoException;
	List<Comment> getAllComment() throws DaoException;
	List<Comment> getCommentTask(String task) throws DaoException;
	 void delete(int id) throws  DaoException ;

	boolean updateComm(Comment comm) throws DaoException;
}
