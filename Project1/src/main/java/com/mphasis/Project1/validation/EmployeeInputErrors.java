package com.mphasis.Project1.validation;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInputErrors {
	
	private List<String> errorMessages;
	private List<String> codes;
	
}
