package com.mph.exception;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		System.out.println("UNF constr");
	}

	public UserNotFoundException(String msg) {
		super(msg);
		System.out.println("UNF :" + msg);
	}

}
