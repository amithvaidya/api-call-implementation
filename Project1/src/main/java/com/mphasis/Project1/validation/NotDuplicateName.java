package com.mphasis.Project1.validation;


import java.lang.annotation.ElementType;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;  
  
import javax.validation.Constraint;  
import javax.validation.Payload;  


@Constraint(validatedBy = NotDuplicateNameValidator.class)  
@Target( { ElementType.METHOD, ElementType.FIELD } )  
@Retention(RetentionPolicy.RUNTIME)  

public @interface NotDuplicateName {
	
    //error message  
    public String message() default EmployeeErrorCodes.ERR_02;  
//represents group of constraints     
    public Class<?>[] groups() default {};  
//represents additional information about annotation  
    public Class<? extends Payload>[] payload() default {};  
}
