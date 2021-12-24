package com.mphasis.Project2.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.cql.CqlTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.Project2.model.DepartmentDTO;
import com.mphasis.Project2.model.MappedDepartments;
import com.mphasis.Project2.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@PostMapping("/MappedDepartments")
	public ResponseEntity<MappedDepartments> getMapping(@RequestBody DepartmentDTO dDto){
		MappedDepartments md = new MappedDepartments();
		md.setMappedDepartments(service.getMappedDepartments(dDto.getEmployee_id()));
		return new ResponseEntity<>(md, HttpStatus.OK);
	}
	
	@PutMapping("/mapEmployee")
	public ResponseEntity<String> mapEmployee(@RequestBody DepartmentDTO dDto){
		service.mapEmployee(dDto);
		return new ResponseEntity<>("Employee mapped succesfully.", HttpStatus.OK);
	}
	
	@PostMapping("/createDepartment")
	public ResponseEntity<String> createDepartment(@RequestBody @Valid DepartmentDTO dDto){
		service.createDepartment(dDto);
		return new ResponseEntity<>("Department created succesfully.", HttpStatus.OK);
	}
	
	
	
}
