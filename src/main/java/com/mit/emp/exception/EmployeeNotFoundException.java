package com.mit.emp.exception;




public class EmployeeNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 764255134607836932L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
