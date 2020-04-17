package org.wang.bootdemo.Exception;

public class ExceptionDao {

	public void executeDao () {
		try {
			int a = 2/0;
		}catch (Exception e) {
//			throw  new InvokeException(-10,e.getMessage());
			throw new MyException(99, e.getMessage(), "myException", "test");
		}

	}
}
