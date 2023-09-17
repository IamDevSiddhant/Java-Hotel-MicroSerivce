package com.siddhant.hotel.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.siddhant.hotel.entity.ApiResponseForException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	//private ApiResponseForException apiResponseForException;
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> exceptionhandling(ResourceNotFoundException ex){
		
		Map map = new HashMap<>();
		
		map.put("message", ex.getMessage());
		map.put("Success", false);
		map.put("status", HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		
	}
	
}
