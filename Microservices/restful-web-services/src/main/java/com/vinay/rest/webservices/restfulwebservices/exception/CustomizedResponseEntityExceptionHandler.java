/**
 * 
 */
package com.vinay.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vinay.rest.webservices.restfulwebservices.user.UserNotFoundException;

/**
 * @author VINAY
 *
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		com.vinay.rest.webservices.restfulwebservices.exception.ExceptionHandler exceptionHandler = new com.vinay.rest.webservices.restfulwebservices.exception.ExceptionHandler(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionHandler,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserDataException(UserNotFoundException ex, WebRequest request) throws Exception {
		
		com.vinay.rest.webservices.restfulwebservices.exception.ExceptionHandler exceptionHandler = new com.vinay.rest.webservices.restfulwebservices.exception.ExceptionHandler(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionHandler,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		com.vinay.rest.webservices.restfulwebservices.exception.ExceptionHandler exceptionHandler = new com.vinay.rest.webservices.restfulwebservices.exception.ExceptionHandler(new Date(), "Validation Failed", ex.getBindingResult().toString());
		
		return new ResponseEntity<Object>(exceptionHandler,HttpStatus.BAD_REQUEST);	}

}
