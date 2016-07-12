package test.z.serviceException;

import test.z.Exception.DaoException;

public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 1010L;
	
	private Exception exception;
	
	public ServiceException(DaoException e) {
		this.exception = e;
	}
	
	public Exception getException() {
		return exception;
	}
	
	public void setException(Exception exception) {
		this.exception = exception;
	}

}
