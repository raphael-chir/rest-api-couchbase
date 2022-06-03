package com.experience.restapicouchbase.infratructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.experience.restapicouchbase.domain.Employee;

@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void crud(){
        // init vars
        String testId = "employee::1";
        
        // Create
        Employee employee = new Employee();
        employee.setId(testId);
        employee.setFirstName("a");
        employeeRepository.save(employee);

        // Read
        Optional<Employee> expectedRead = employeeRepository.findById(testId);
        assertTrue(expectedRead.isPresent());
        assertEquals(testId, expectedRead.get().getId());

        // Update
        expectedRead.get().setFirstName("b");
        employeeRepository.save(expectedRead.get());
        Optional<Employee> expectedUpdate = employeeRepository.findById(testId);
        assertTrue(expectedUpdate.isPresent());
        assertEquals("b", expectedUpdate.get().getFirstName());

        // Delete
        employeeRepository.deleteById(testId);
        Optional<Employee> expectedDelete = employeeRepository.findById(testId);
        assertTrue(expectedDelete.isEmpty());
    }
}
