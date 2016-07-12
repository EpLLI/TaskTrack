package test.z.service;

import java.util.List;


import test.z.pojos.Comment;
import test.z.pojos.Task;
import test.z.pojos.User;
import test.z.serviceException.ServiceException;

public interface ICommentService extends Services<Comment>{
	 void addComment(Comment comm) throws ServiceException;
	 public List<Comment> getAllComment()throws ServiceException;
	 List<Comment> getCommentTask(String task) throws ServiceException;
	 void delete(int id) throws ServiceException ;
	 boolean updateComm(Comment comm) throws ServiceException;

}
