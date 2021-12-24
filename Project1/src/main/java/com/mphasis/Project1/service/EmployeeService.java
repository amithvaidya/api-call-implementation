package com.mphasis.Project1.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.Project1.model.Employee;
import com.mphasis.Project1.model.EmployeeDTO;
import com.mphasis.Project1.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	public void addEmployee(Employee emp) {
		LocalDateTime created_date = LocalDateTime.now();
		emp.setEmployee_id(UUID.randomUUID());
		emp.setCreated_date(created_date);
		emp.setUpdated_date(created_date);
		repo.save(emp);
		created_date=null;
		emp=null;
	}
	
	public void updateEmployee(EmployeeDTO empDTO) {
		
		LocalDateTime updated_date = LocalDateTime.now();
		Employee emp = new Employee();
		
		List<Employee> emps= repo.findAll();
		loop: for(Employee temp: emps) {
			if(temp.getEmployee_identity_number() == empDTO.getEmployee_identity_number()) {
				emp.setEmployee_identity_number(empDTO.getEmployee_identity_number());
				emp.setEmployee_name(empDTO.getEmployee_name());
				emp.setEmployee_salary(empDTO.getSalary());
				emp.setEmployee_mobile(empDTO.getEmployee_mobile());
				emp.setEmployee_id(temp.getEmployee_id());
				emp.setCreated_date(temp.getCreated_date());
				emp.setUpdated_date(updated_date);
				break loop;
			} 
			
		}
		repo.save(emp);
		updated_date=null;
		emps=null;
		
	}
	
	public void deleteEmployee(int empIdNum) {
		List<Employee> emps= repo.findAll();
		for(Employee temp: emps) {
			if(temp.getEmployee_identity_number() == empIdNum) {
				repo.deleteById(temp.getEmployee_id());
				break;
			}
			
		}
		emps=null;
	}
	public void deleteAll() {
		repo.deleteAll();
	}
}
