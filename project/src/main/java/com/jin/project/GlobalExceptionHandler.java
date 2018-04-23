package com.jin.project;

import javax.naming.NoPermissionException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@CrossOrigin
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler
	public String processException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		if(ex instanceof MissingServletRequestParameterException) {
			return "no params";
		}
		if(ex instanceof NoPermissions) {
			logger.error(ex.getMessage());
			return "no permit";
		}
		logger.error(ex.toString());
		return "3333";
	}
}
