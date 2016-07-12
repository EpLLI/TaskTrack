package test.z.service;

import test.z.serviceException.ServiceException;

public interface Services<T> {
	T getById(Long id) throws ServiceException;

	void add(T model) throws ServiceException;

	void update(T model) throws ServiceException;

	void remove(Integer x) throws ServiceException;

	void remove(T model) throws ServiceException;

}
