package com.iso.poreport.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ImUserAbsenceNotFoundException extends RuntimeException {
	public ImUserAbsenceNotFoundException(String message) {
		super(message);
	}

}
