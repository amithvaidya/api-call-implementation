package com.mphasis.Project2.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.catalina.Cluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.cql.CqlTemplate;
import org.springframework.stereotype.Service;

import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.mphasis.Project2.model.Department;
import com.mphasis.Project2.model.DepartmentDTO;
import com.mphasis.Project2.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	
	@Autowired
	private DepartmentRepository repo;


	
	public List<String> getMappedDepartments(UUID empId){
		List<String> mappedDepts = new ArrayList<>();
		List<UUID> empIdList;
		List<Department> depts = repo.findAll();
		for(Department tempDept: depts) {
			empIdList = tempDept.getEmployee_id();
			if(empIdList!=null)
			empSearchLoop: for(UUID tempId: empIdList) {
				if(tempId.equals(empId)) {
					mappedDepts.add(tempDept.getDepartment_name());
					break empSearchLoop;
				}
			}
		}
		
		return mappedDepts;
	}
	
	public void createDepartment(DepartmentDTO dDto) {
		Department dept = new Department();
		dept.setDepartment_id(UUID.randomUUID());
		dept.setDepartment_name(dDto.getDepartment_name());
		dept.setDepartment_contact_number(dDto.getDepartment_contact_number());
		dept.setCreated_date(LocalDateTime.now());
		dept.setUpdated_date(LocalDateTime.now());
		dept.setEmployee_id(null);
		repo.save(dept);
	}
	
	public void mapEmployee(DepartmentDTO dDto) {
		
		List<Department> depts= repo.findAll();
		List<UUID> empIdList;
		
		for(Department tempDept: depts) {
			if(tempDept.getDepartment_name().equals(dDto.getDepartment_name())) {
				if(tempDept.getEmployee_id() == null) {
					empIdList = new ArrayList<>();
					empIdList.add(dDto.getEmployee_id());
				}
				else {
					empIdList = tempDept.getEmployee_id();
					empIdList.add(dDto.getEmployee_id());
				}
				empIdList.add(dDto.getEmployee_id());
				
				tempDept.setEmployee_id(empIdList);
				tempDept.setUpdated_date(LocalDateTime.now());
				repo.save(tempDept);
				break;
			}
		}
		
		
		
		//return cql.execute("update department set employee_id = employee_id + "+dDto.getEmployee_id().toString()+" where department_id = \""+getDeptIdByName.toString()+"\"");
		
	}
	
}
