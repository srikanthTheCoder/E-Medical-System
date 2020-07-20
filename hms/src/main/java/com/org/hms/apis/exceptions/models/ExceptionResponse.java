package com.org.hms.apis.exceptions.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class ExceptionResponse {

	@JsonIgnore
	private Integer status;
	private HttpStatus code;
	private String message;
	private List<ServiceValidationError> errors = new ArrayList<>();

	public ExceptionResponse(HttpStatus code, Integer status) {
		this.status = status;
		this.code = code;
		this.message = "Unknown Error";
	}

	public void addValidationErrors(List<FieldError> fieldErrors) {
		errors = new ArrayList<>();
		fieldErrors.forEach(fe -> errors.add(new ServiceValidationError(fe.getObjectName(), fe.getCode(), fe.getField(),
				fe.getRejectedValue(), fe.getDefaultMessage())));
	}

	public void addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
		errors = new ArrayList<>();
		constraintViolations.forEach(cv -> errors.add(new ServiceValidationError(cv.getRootBeanClass().getSimpleName(),
				cv.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName(),
				((PathImpl) cv.getPropertyPath()).getLeafNode().asString(), cv.getInvalidValue(), cv.getMessage())));
	}

	public void addValidationObjectErrors(List<ObjectError> objectErrors) {
		errors = new ArrayList<>();
		objectErrors.forEach(
				oe -> errors.add(new ServiceValidationError(oe.getObjectName(), oe.getCode(), oe.getDefaultMessage())));
	}

	@Data
	class ServiceValidationError {

		@JsonIgnore
		private String object;
		private String code;
		private String field;
		private Object errorObject;
		private String message;

		ServiceValidationError(String object, String code, String message) {
			this.object = object;
			this.code = code;
			this.message = message;
		}

		ServiceValidationError(String object, String code, String field, Object errorObject, String message) {
			this.object = object;
			this.code = code;
			this.field = field;
			this.errorObject = errorObject;
			this.message = message;
		}
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ServiceValidationError> getErrors() {
		return errors;
	}

	public void setErrors(List<ServiceValidationError> errors) {
		this.errors = errors;
	}

}