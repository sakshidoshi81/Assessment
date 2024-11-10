package com.etiqa.infrastructure.exceptions;

/**
 * 
 * @author Sakshi Doshi
 * user defined exception
 *
 */
public class InvalidEntryException extends Exception {

	/**
	 * default serial version uid
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message
	 * constructor to accept exception message
	 */
	public InvalidEntryException(String message){
		super(message);
	}
}
