package com.educandoweb.course.advice;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.educandoweb.course.exception.UserNotFindException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ResourceExceptionHandler {
	

	@ExceptionHandler(UserNotFindException.class)
	public ResponseEntity<Object> erro(UserNotFindException j) {
		log.error(j.getMessage());
		return ResponseEntity.notFound().build();
	}
}
