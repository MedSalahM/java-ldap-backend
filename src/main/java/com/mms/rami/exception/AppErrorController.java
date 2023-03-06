package com.mms.rami.exception;

import java.net.UnknownHostException;

import javax.naming.NamingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppErrorController {

	
	
	@ExceptionHandler(NamingException.class)
	public ResponseEntity<ProblemDetail> handlleNamingException(NamingException ex) {
		
		 var a =	HttpStatus.INTERNAL_SERVER_ERROR;
			
			ProblemDetail apiError = ProblemDetail.forStatusAndDetail(a, ex.getMessage()) ;
			
			return new ResponseEntity<ProblemDetail>(apiError ,a );

		
		
	}
	
	@ExceptionHandler(UnknownHostException.class)
	public ResponseEntity<ProblemDetail> handlUnknownhost(UnknownHostException ex) {
		
		 var a =	HttpStatus.INTERNAL_SERVER_ERROR;
			
			ProblemDetail apiError = ProblemDetail.forStatusAndDetail(a, ex.getMessage()) ;
			
			return new ResponseEntity<ProblemDetail>(apiError ,a );

		
		
	}
}
