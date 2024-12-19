package org.jsp.cda.exceptionclassess;

import lombok.Builder;

@Builder
public class InvalidDeptIdException {
	String message;
	public InvalidDeptIdException() {
		
	}
	public InvalidDeptIdException(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
