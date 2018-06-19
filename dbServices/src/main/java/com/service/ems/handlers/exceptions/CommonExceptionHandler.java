package com.service.ems.handlers.exceptions;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.service.ems.exceptions.ApiError;


@ControllerAdvice

public class CommonExceptionHandler extends ResponseEntityExceptionHandler{
	 
	 public static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
	    
	    
	    @ExceptionHandler(SQLException.class)
		public String handleSQLException(HttpServletRequest request, Exception ex){
			logger.info("SQLException Occured:: URL="+request.getRequestURL());
			return "database_error";
		}
		
		@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Internal error")
		@ExceptionHandler(IOException.class)
		public void handleIOException(HttpServletRequest request, Exception ex){
			logger.error(request.getUserPrincipal().getName() , ex);
		}


		 @Override
		   protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		       String error = "JSON request error";
		       return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
		   }

		   private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		       return new ResponseEntity<>(apiError, apiError.getStatus());
		   }
}
