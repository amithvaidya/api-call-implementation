package com.mphasis.Project1.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mphasis.Project1.model.DepartmentDTO;
import com.mphasis.Project1.model.Employee;
import com.mphasis.Project1.model.EmployeeDTO;
import com.mphasis.Project1.model.MappedDepartments;
import com.mphasis.Project1.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	private RestTemplate restTemplate;
	
	private static Logger logger = LogManager.getLogger(EmployeeController.class);
	@GetMapping("/allEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity(service.getAllEmployees(), HttpStatus.OK);
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody @Valid EmployeeDTO empDTO) {
		Employee emp = new Employee();
		emp.setEmployee_identity_number(empDTO.getEmployee_identity_number());
		emp.setEmployee_name(empDTO.getEmployee_name());
		emp.setEmployee_salary(empDTO.getSalary());
		emp.setEmployee_mobile(empDTO.getEmployee_mobile());
		service.addEmployee(emp);
		return new ResponseEntity<String>("Employee succesfully added.", HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO emp) {
		service.updateEmployee(emp);	
		return new ResponseEntity<String>("Employee details updated.", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<String> deleteEmployee(@RequestBody int emp) {
		service.deleteEmployee(emp);
		return new ResponseEntity<String>("Employee removed succesfully.", HttpStatus.OK);
	}
	
	@GetMapping("/deletAll")
	public ResponseEntity<String> deleteAll() {
		service.deleteAll();
		return new ResponseEntity<String>("All Employees removed succesfully.", HttpStatus.OK);
		
	}
	
	@PostMapping("/mappedDepartments")
	public Object getMappedDept(@RequestBody DepartmentDTO deptDto){
		EmployeeController.logger.info("API call made from Employee to Department.");
		return new ResponseEntity((new RestTemplate()).postForEntity("http://localhost:8082/getMappedDepartments",deptDto, MappedDepartments.class), HttpStatus.OK).getBody();
	}
	public static void main(String[] args) {
		logger.info("Logger called.");
		logger.warn("WARN");
		logger.debug("DEBUG");
	}
}
