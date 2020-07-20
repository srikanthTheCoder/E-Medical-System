package com.org.hms.apis.v1.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.TYPE_USE,
		ElementType.CONSTRUCTOR })
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidatorImpl.class)
public @interface EnumValidator {

	Class<? extends Enum<?>> enumType();

	String message() default "Given value is invalid";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String anyOf() default "";

	boolean required() default false;

}
