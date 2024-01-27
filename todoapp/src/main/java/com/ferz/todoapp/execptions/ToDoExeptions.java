/**
 * 
 */
package com.ferz.todoapp.execptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * @author Lynkos
 *
 */
@Data
public class ToDoExeptions extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private HttpStatus httpStatus;
	/**
	 * @param message
	 * @param httpStatus
	 */
	public ToDoExeptions(String message, HttpStatus httpStatus) {
		super(message);
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	

}
