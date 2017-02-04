package it.flare.ddd.exception;

public class SystemException extends AppException {

	public SystemException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SystemException(Integer errorcode, Throwable cause) {
		super(errorcode, cause);
		// TODO Auto-generated constructor stub
	}

	public SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SystemException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SystemException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
