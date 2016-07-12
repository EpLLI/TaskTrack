package test.z.Exception;
import java.sql.SQLException;

import org.hibernate.HibernateException;

public class DaoException extends Exception {
private static final long serialVersionUID = 1L;
	
	private Exception exception;
	
	public DaoException(String message, SQLException e) {
		setException(e);
	}
	public DaoException(HibernateException e) {
		this.exception = e;
	}
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
}
