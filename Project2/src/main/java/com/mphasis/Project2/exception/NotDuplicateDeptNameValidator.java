package com.mphasis.Project2.exception;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mphasis.Project2.model.Department;
import com.mphasis.Project2.repository.DepartmentRepository;

public class NotDuplicateDeptNameValidator implements ConstraintValidator<NotDuplicateDeptName, String>{
	
	@Autowired
	private DepartmentRepository repo;
	
	public boolean isValid(String s, ConstraintValidatorContext cvc) {
		List<Department> departments = repo.findAll();
		boolean flag=true;
		for(Department temp: departments) {
			System.out.println(temp.toString());
			if(s.equals(temp.getDepartment_name())) { 
				System.out.println("Duplicate department!!!!!");
				flag = false;
				break;
			}
		}
		return false;
	}
}
