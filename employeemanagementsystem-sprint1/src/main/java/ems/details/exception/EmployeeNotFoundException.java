package ems.details.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_MODIFIED)
public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
