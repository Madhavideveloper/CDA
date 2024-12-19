package org.jsp.cda.responcestructure;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResponceStructure<T> {
private int httpStatus;
private String message;
private T body;
}
