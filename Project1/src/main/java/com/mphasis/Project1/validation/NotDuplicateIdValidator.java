package com.mphasis.Project1.validation;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;  
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mphasis.Project1.model.Employee;
import com.mphasis.Project1.repository.EmployeeRepository;  

public class NotDuplicateIdValidator implements ConstraintValidator<NotDuplicateId, Integer>{
	@Autowired
	private EmployeeRepository repo;
	
    public boolean isValid(Integer s, ConstraintValidatorContext cvc) {  
        List<Employee> emps= new ArrayList();
        emps = repo.findAll();
        for(Employee sample: emps) {
        	if(s.equals(sample.getEmployee_identity_number())) { 
        		emps=null;
        		return false;
        	}
        }
        
        return true;  
    }
}
