package com.org.hms.apis.exceptions;

import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.org.hms.apis.exceptions.models.ErrorResponse;
import com.org.hms.apis.exceptions.models.ExceptionResponse;

@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(ServiceExceptionHandler.class);

	@Autowired
	@Qualifier("validationResource")
	private MessageSource validationMessageSource;

	protected String getValidationMessage(String key) {
		return Optional.ofNullable(validationMessageSource.getMessage(key, null, Locale.US)).orElse("");
	}

	/**
	 * Handles javax.validation.ConstraintViolationException. Thrown when @Validated
	 * fails.
	 */

	protected ResponseEntity<Object> buildResponseEntity(ExceptionResponse response) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setError(response);
		return ResponseEntity.status(response.getCode()).headers(new HttpHeaders()).body(errorResponse);
	}

	/**
	 * Handle MethodArgumentNotValidException. Triggered when an object fails @Valid
	 * validation.
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error(ex.getMessage(), ex);
		ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		response.setMessage("VALIDATION_ERROR");
		response.addValidationErrors(ex.getBindingResult().getFieldErrors());

		return buildResponseEntity(response);
	}

	/**
	 * Handle MethodArgumentNotValidException. Triggered when an object fails @Valid
	 * validation.
	 */
	protected ResponseEntity<Object> handleMethodArgumentNotValidObject(MethodArgumentNotValidException ex) {
		log.error(ex.getMessage(), ex);
		ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		response.setMessage("VALIDATION_ERROR");
		response.addValidationObjectErrors(ex.getBindingResult().getGlobalErrors());

		return buildResponseEntity(response);
	}

	/**
	 * Handles javax.validation.ConstraintViolationException. Thrown when @Validated
	 * fails.
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex,
			HttpServletRequest request) {
		log.error(ex.getMessage(), ex);
		ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value());
		response.setMessage("CONSTRAINT_VIOLATION");
		response.addValidationErrors(ex.getConstraintViolations());

		return buildResponseEntity(response);
	}

}
