package test.z.dao.dao;


import java.util.List;


import test.z.Exception.DaoException;
import test.z.pojos.User;


public interface ManDao extends Dao<User> {
	void saveOrUpdate(User user) throws DaoException;
	List<User> getAllUser() throws DaoException;
	List<User> getAllDev() throws DaoException;
	 void delete(int id) throws  DaoException ;
	 boolean updateDev(User user) throws DaoException;
}
