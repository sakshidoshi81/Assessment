package com.etiqa.infrastructure.exceptions;

/**
 * 
 * @author Sakshi Doshi
 * user defined exception
 *
 */
public class DuplicateEntryException extends Exception {

	/**
	 * default serial version uid
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message
	 * constructor to accept exception message
	 */
	public DuplicateEntryException(String message){
		super(message);
	}
	
	/**
	 * 
	 * @param e
	 * constructor to accept exception
	 */
	public DuplicateEntryException(Exception e){
		super(e);
	}
}
