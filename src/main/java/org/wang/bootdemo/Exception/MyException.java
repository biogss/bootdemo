package org.wang.bootdemo.Exception;

public class MyException extends RuntimeException {
	/**
	 * 错误码
	 */
	private int errorCode;

	/**
	 * 错误类型
	 */
	private String errorType;

	/**
	 * 业务类型
	 */
	private String errorBusiness;

	public MyException() {
		super();
	}

	/**
	 * 初始化exception
	 * @param errorCode
	 * @param message
	 * @param errorType
	 * @param errorBusiness
	 */
	public MyException(int errorCode, String message, String errorType, String errorBusiness){
		super( message);
		this.errorCode = errorCode;
		this.errorType = errorType;
		this.errorBusiness = errorBusiness;
	}

	public int getErrorCode() {
		return this.errorCode;
	}

	public String getErrorType() {
		return this.errorType;
	}

	public String getErrorBusiness() {
		return this.errorBusiness;
	}

}
