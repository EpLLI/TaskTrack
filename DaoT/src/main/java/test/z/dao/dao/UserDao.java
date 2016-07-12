package test.z.dao.dao;

import test.z.Exception.DaoException;
import test.z.pojos.User;

public interface UserDao {

	public User getUserById(int id) throws DaoException;

	User findByUserName(String username) throws DaoException;

}