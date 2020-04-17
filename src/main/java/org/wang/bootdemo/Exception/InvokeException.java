package org.wang.bootdemo.Exception;

public class InvokeException extends RuntimeException {

	 private static final long serialVersionUID = 1L;

	 private int errorCode;

	 public int getErrorCode()
	 {
	    return errorCode;
	  }

  private int errorType = -1;

  public int getErrorType()
  {
	     return errorType;
	 }

  @Deprecated
  public InvokeException(int errorCode, String message)
	 {
	   super(message);
	   this.errorCode = errorCode;
	   }

	  @Deprecated
	  public InvokeException(int errorCode, String message, Throwable cause)
	  {
	     super(message, cause);
	    this.errorCode = errorCode;
	  }

	   public InvokeException(String message, int errorType)
	 {
		    super(message);
		    this.errorType = getErrorType(errorType);
	   }

	  public InvokeException(String message, Throwable cause, int errorType)
  {
		   super(message, cause);
		    this.errorType = getErrorType(errorType);
		 }

  private int getErrorType(int errorType)
	 {
	    if (errorType > 100)
		    {
			     return 99;
			   }
		   if (errorType < 0)
		    {
	       return 0;
	     }

		    return errorType;
	   }
	
}
