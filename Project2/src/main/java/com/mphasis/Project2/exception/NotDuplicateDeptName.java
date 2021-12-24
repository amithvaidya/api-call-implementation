package com.mphasis.Project2.exception;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.lang.model.element.Element;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = NotDuplicateDeptNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface NotDuplicateDeptName {
	
	public String message() default "This department name exsists. Please choose another name for the department.";
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {}; 
}
