package com.devsuperior.dstarefa01.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.dstarefa01.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<EntityNotFoundError> entityNotFound(ResourceNotFoundException e
			, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		EntityNotFoundError err = new EntityNotFoundError(
				Instant.now()
				, status.value()
				,"Resource not found!" 
				, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
