package com.etiqa.infrastructure.exceptions;

/**
 * 
 * @author Sakshi Doshi
 * custom exception
 *
 */
public class ResultNotFoundException extends Exception {

	/**
	 * default serial version uid
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message
	 * constructor to accept exception message
	 */
	public ResultNotFoundException(String message){
		super(message);
	}
}
