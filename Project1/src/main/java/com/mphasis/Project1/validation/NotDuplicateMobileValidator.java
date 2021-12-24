package com.mphasis.Project1.validation;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;  
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mphasis.Project1.model.Employee;
import com.mphasis.Project1.repository.EmployeeRepository;  

public class NotDuplicateMobileValidator implements ConstraintValidator<NotDuplicateMobile, String>{
	@Autowired
	private EmployeeRepository repo;
	
    public boolean isValid(String s, ConstraintValidatorContext cvc) {  
        List<Employee> emps= new ArrayList();
        emps = repo.findAll();
        for(Employee sample: emps) {
        	if(s.equals(sample.getEmployee_mobile())) { 
        		emps=null;
        		return false;
        	}
        }
        
        return true;  
    }
}