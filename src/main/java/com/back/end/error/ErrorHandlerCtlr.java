package com.back.end.error;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

@ControllerAdvice
public class ErrorHandlerCtlr {

	private static final Logger logger = LoggerFactory.getLogger(ErrorHandlerCtlr.class);

	@Value("%{error.include.stacktrace}")
	private String includeStacktrace;

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<Map<String, String>> handleAccessDeniedErros(AccessDeniedException e) {
		Map<String, String> errorModel = Maps.newHashMap();
		errorModel.put("status", HttpStatus.FORBIDDEN + "");
		errorModel.put("message", e.getMessage());
		return new ResponseEntity<>(errorModel, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(AccountStatusException.class)
	public ResponseEntity<Map<String, String>> handleAuthenticationErrors(AccountStatusException e) {
		return getResponseEntity(e, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Map<String, String>> handleNotFound(HttpServletRequest req) {
		Map<String, String> errorModel = Maps.newHashMap();
		errorModel.put("status", HttpStatus.NOT_FOUND + "");
		errorModel.put("message", "Url - '" + req.getRequestURI() + "' does not exist.");
		return new ResponseEntity<>(errorModel, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({MissingServletRequestParameterException.class, HttpRequestMethodNotSupportedException.class})
	public ResponseEntity<Map<String, String>> handleBadRequest(HttpServletRequest req) {
		Map<String, String> errorModel = Maps.newHashMap();
		errorModel.put("status", HttpStatus.BAD_REQUEST + "");
		errorModel.put("message", "Please, check your request parameters.");
		return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleInternalServerError(Exception e) {
		return getResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<Map<String, String>> getResponseEntity(Exception e, HttpStatus status) {
		Map<String, String> errorModel = Maps.newHashMap();
		errorModel.put("status", status.value() + "");
		errorModel.put("message", e.getMessage());
		if (Boolean.valueOf(includeStacktrace)) {
			errorModel.put("exceptionType", e.getClass().getName());
			errorModel.put("stackTrace", stackTraceToString(e));
			logger.error("Exception thrown on Web layer of REST API application: ", e);
		}
		return new ResponseEntity<>(errorModel, status);
	}

	private String stackTraceToString(Throwable ex) {
		if (ex != null) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			return sw.toString();
		}
		return "No exceptions were found.";
	}
}