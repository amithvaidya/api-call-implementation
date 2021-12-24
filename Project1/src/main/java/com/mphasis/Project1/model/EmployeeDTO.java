package com.mphasis.Project1.model;

import javax.validation.constraints.NotNull;

import com.mphasis.Project1.validation.NotDuplicateId;
import com.mphasis.Project1.validation.NotDuplicateMobile;
import com.mphasis.Project1.validation.NotDuplicateName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	
	@NotNull(message="{validation.employee_identity_number.NotEmpty}")
	@NotDuplicateId
	private Integer employee_identity_number;
	
	@NotNull
	@NotDuplicateName
	private String employee_name;
	
	private float salary;
	
	@NotDuplicateMobile
	private String employee_mobile;
}
