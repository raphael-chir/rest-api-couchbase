package com.experience.restapicouchbase.infratructure;

import org.springframework.data.repository.CrudRepository;

import com.experience.restapicouchbase.domain.Employee;

interface EmployeeRepository extends CrudRepository<Employee, String>{

    
}
