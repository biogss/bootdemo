package org.wang.bootdemo.Exception;

import jdk.nashorn.internal.runtime.ECMAException;

public class ExceptionService {

	private ExceptionDao ed = new ExceptionDao();
	public void execute() {
		try {
			ed.executeDao();
			System.out.println("ExceptionService");
		} catch (InvokeException e) {
			System.out.println("invokeException run!" + e.getMessage());
		}catch (Exception e) {
			System.out.println("exception");
		}

	}

	public static void main(String[] args) {
		ExceptionService es = new ExceptionService();
		es.execute();
	}
}
