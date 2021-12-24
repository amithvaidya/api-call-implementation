package com.mphasis.Project1.validation;
import java.lang.annotation.ElementType;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;  
  
import javax.validation.Constraint;  
import javax.validation.Payload;  


@Constraint(validatedBy = NotDuplicateIdValidator.class)  
@Target( { ElementType.METHOD, ElementType.FIELD } )  
@Retention(RetentionPolicy.RUNTIME)

public @interface NotDuplicateId {
	public String message() default EmployeeErrorCodes.ERR_01;
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {}; 
}