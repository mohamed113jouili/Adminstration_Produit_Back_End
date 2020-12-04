package com.produit.web.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.UnexpectedTypeException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.produit.web.model.ApiResponse;
import com.produit.web.model.ValidationResponse;
@ControllerAdvice
public class AppExceptionHandeller {
	
	
	/*** exception validation object ... **/
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidation(MethodArgumentNotValidException ex, WebRequest request) {

		List<String> subErrors = new ArrayList<String>();

		subErrors = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> error.getField() + " : " + error.getDefaultMessage()).collect(Collectors.toList());

		ValidationResponse apiError = new ValidationResponse(HttpStatus.BAD_REQUEST,
				ex.getLocalizedMessage().substring(0, 120) + "...", 1, " Validation Error, type 1 validation form",
				subErrors);

		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	/*** exception validation Format object  Date ... **/

	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<Object> handleInvalidFormatDate(InvalidFormatException ex, WebRequest request) {

		ApiResponse apiError = new ApiResponse(HttpStatus.BAD_REQUEST, ex.getMessage().substring(0, 100) + "...", 2,
				"Invalid Format Date, must be verified format  yyyy-MM-dd ");

		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	/*** exception validation object ... **/

	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<Object> handleValidationObject(UnexpectedTypeException ex, WebRequest request) {

		ApiResponse apiError = new ApiResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), 11,
				"Invalid  object type 11  ");

		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	/*** exception Null object  ... **/

	@ExceptionHandler(CustomNullPointException.class)
	public ResponseEntity<Object> vv(CustomNullPointException ex, WebRequest request) {

		ApiResponse apiError = new ApiResponse(HttpStatus.BAD_REQUEST, ex.getMesage(), ex.getType(), ex.getComment());

		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	
	/***duplicate  key object **/
	
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		
		
		
		String constraintName=ex.getConstraintName();

		ApiResponse apiError = new ApiResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), 100,
				"duplicate "+constraintName);
		
		
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	
	
}
