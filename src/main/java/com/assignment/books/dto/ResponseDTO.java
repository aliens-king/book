/**
 * 
 */
package com.assignment.books.dto;

import java.io.Serializable;

import org.springframework.http.HttpStatus;


/**
 * @author SUDHANSHU
 *
 */
public class ResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -212651961961257920L;

	private HttpStatus status;

	private int code;

	private Object data;

	private String message = "";

	/**
	 * 
	 */
	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param status
	 * @param code
	 * @param message
	 */
	public ResponseDTO(HttpStatus status, int code, String message) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
	}



	/**
	 * @param status
	 * @param data
	 */
	public ResponseDTO(HttpStatus status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}

	/**
	 * @param status
	 * @param code
	 * @param data
	 * @param message
	 */
	public ResponseDTO(HttpStatus status, int code, Object data, String message) {
		super();
		this.status = status;
		this.code = code;
		this.data = data;
		this.message = message;
	}

	/**
	 * @param status
	 * @param data
	 * @param message
	 */
	public ResponseDTO(HttpStatus status, Object data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public final HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public final void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * @return the data
	 */
	public final Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public final void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public final void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public final int getcode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public final void setcode(int code) {
		this.code = code;
	}

}
