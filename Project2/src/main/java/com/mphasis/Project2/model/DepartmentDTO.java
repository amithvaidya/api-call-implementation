package com.mphasis.Project2.model;

import java.util.UUID;

import com.mphasis.Project2.exception.NotDuplicateDeptName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
	
	private UUID employee_id;
	
	@NotDuplicateDeptName
	private String department_name;
	
	private String department_contact_number;
	
}
