package com.experience.restapicouchbase.infratructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.experience.restapicouchbase.domain.Employee;
import com.experience.restapicouchbase.domain.Title;

@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Test
    void crud(){
        // init vars
        String testId = "employee::1";
        
        // Create
        Employee employee = new Employee(testId, new Date(), "a", "b", "c", new Date(), null);        
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

    @Test
    void joinOnKeys(){
        
         // init vars
         String testId = "employee::1";
         String titleId = "title::1";
        // Create 
        Employee employee = new Employee(testId, new Date(), "a", "b", "c", new Date(), null); 
        Title title = new Title(titleId,testId, "a", new Date(), new Date());
        employeeRepository.save(employee);
        titleRepository.save(title);

        // Read
        Optional<Employee> expectedRead = employeeRepository.findById(testId);
        assertTrue(expectedRead.isPresent());
        assertEquals(1, expectedRead.get().getTitles().size());
        assertEquals("a", expectedRead.get().getTitles().get(0).getTitle());
        

    }

}
