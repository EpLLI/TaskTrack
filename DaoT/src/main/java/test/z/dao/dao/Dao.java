package test.z.dao.dao;

import test.z.Exception.DaoException;

public interface Dao <T> {
	public T getById(Long id) throws DaoException;
	public void add(T model)throws DaoException;
	public void update(T model)throws DaoException;
	public void remove (Integer id)throws DaoException;
	public void remove (T model)throws DaoException;
}
