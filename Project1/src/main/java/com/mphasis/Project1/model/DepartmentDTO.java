package com.mphasis.Project1.model;

import java.util.UUID;

import com.mphasis.Project1.model.DepartmentDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
	private String department_name;
	private String department_contact_number;
	private UUID employee_id;
}
