package com.walter.workshopmongo.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.walter.workshopmongo.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req) {
		Long timestamp = System.currentTimeMillis();
		Integer status = HttpStatus.NOT_FOUND.value();
		String error = "Not found";
		String path = req.getRequestURI();
		String message = e.getMessage();
		
		StandardError err = new StandardError(timestamp, status, error, message, path);
		
		return ResponseEntity.status(status).body(err);
	}
}
