package it.flare.ddd.exception;

public class AppException extends RuntimeException {

	Integer errorcode;
	
	public Integer getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}
	public AppException(Integer errorcode,  Throwable cause) {
		super(cause);
		this.errorcode = errorcode;
		
	}
	public AppException(Integer errorcode,  String message) {
		super(message);
		this.errorcode = errorcode;
		
	}
	
	public AppException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public AppException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public AppException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public AppException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
