package org.jsp.cda.exceptionclassess;

import lombok.Builder;

@Builder
public class InvalidIdException extends RuntimeException{
	String message;
	public InvalidIdException() {
		
	}
	public InvalidIdException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}
}
