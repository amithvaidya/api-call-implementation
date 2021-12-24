package com.mphasis.Project2.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.Project2.model.Department;

public interface DepartmentRepository extends CassandraRepository<Department, UUID>{
	
}
