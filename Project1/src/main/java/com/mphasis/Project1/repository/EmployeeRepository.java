package com.mphasis.Project1.repository;

import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.mphasis.Project1.model.Employee;

public interface EmployeeRepository extends CassandraRepository<Employee, UUID>{
	
}
