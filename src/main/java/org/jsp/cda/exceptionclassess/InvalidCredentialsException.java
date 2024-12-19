package org.jsp.cda.exceptionclassess;

import lombok.Builder;

@Builder
public class InvalidCredentialsException extends RuntimeException{
String message;
public InvalidCredentialsException(String message) {
	this.message=message;
}
public InvalidCredentialsException() {
	
}
@Override
public String getMessage() {
	return this.message;
}
}
