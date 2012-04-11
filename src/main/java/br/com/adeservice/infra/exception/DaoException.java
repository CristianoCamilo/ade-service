package br.com.adeservice.infra.exception;

/**
 * Apr 2, 2012
 * @author fabio
 */
public class DaoException extends RuntimeException {

	private static final long serialVersionUID = -8480115783878932860L;
	
	public DaoException() { super(); }
	public DaoException(final String message, final Throwable cause) { super(message, cause); }
	public DaoException(final String message) { super(message); }
	public DaoException(final Throwable cause) { super(cause); }
	
}