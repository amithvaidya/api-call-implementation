package com.mphasis.Project1.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

@RestControllerAdvice
public class EmployeeExceptionController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> seas(MethodArgumentNotValidException ex){
		List<ObjectError> errors = ex.getBindingResult().getAllErrors();
		List<String> messages = new ArrayList<String>();
		List<String> codes = new ArrayList<String>();
		
		for(ObjectError temp: errors) {
			messages.add(temp.getDefaultMessage());
			codes.add(temp.getCode());
		}
		
		EmployeeInputErrors err = new EmployeeInputErrors();
		err.setErrorMessages(messages);
		err.setCodes(codes);
		return new ResponseEntity(err, HttpStatus.BAD_REQUEST); // new ResponseEntity(msg, HttpStatus.NOT_ACCEPTABLE);
	}
}
