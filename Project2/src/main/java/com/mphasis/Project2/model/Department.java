package com.mphasis.Project2.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.repository.Query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Department {
	
	@PrimaryKey
	private UUID department_id;
	private String department_name;
	private List<UUID> employee_id;
	private String department_contact_number;
	private LocalDateTime created_date;
	private LocalDateTime updated_date;
}
