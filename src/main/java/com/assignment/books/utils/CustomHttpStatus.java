package com.assignment.books.utils;

public class CustomHttpStatus {

	
	
	public enum BookHTTPStatus {
		SUCCESS(101), 
		FAILED(102);
		
		private int code;

		private BookHTTPStatus(int code) {
			this.code = code;

		}

		/**
		 * @return the value
		 */
		public final int getValue() {
			return code;
		}
	}
	

	
	
	
}
