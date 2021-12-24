package com.mphasis.Project1.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.mphasis.Project1.validation.NotDuplicateId;
import com.mphasis.Project1.validation.NotDuplicateMobile;
import com.mphasis.Project1.validation.NotDuplicateName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@PrimaryKey
	private UUID employee_id;
	private int employee_identity_number;
	private String employee_name;
	private String employee_mobile;
	private float employee_salary;
	private LocalDateTime created_date;
	private LocalDateTime updated_date;

	
}
