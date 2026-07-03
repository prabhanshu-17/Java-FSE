package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class EmployeeApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeApplication.class);
    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployeeApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);

        LOGGER.info("Inside EmployeeApplication main");
        
        // 1. Test Adding New Employees
        testAddEmployee();

        // 2. Test Retrieving All Employees
        testGetAllEmployees();
    }

    private static void testAddEmployee() {
        LOGGER.info("Start: testAddEmployee");
        
        Employee emp1 = new Employee("Alice Smith", "Engineering", 75000.00);
        Employee emp2 = new Employee("Bob Jones", "Marketing", 62000.00);

        Integer id1 = employeeService.addEmployee(emp1);
        Integer id2 = employeeService.addEmployee(emp2);

        LOGGER.debug("Successfully inserted Employees with IDs: {} and {}", id1, id2);
        LOGGER.info("End: testAddEmployee");
    }

    private static void testGetAllEmployees() {
        LOGGER.info("Start: testGetAllEmployees");
        
        List<Employee> employees = employeeService.getAllEmployees();
        LOGGER.debug("Fetched Employee List: {}", employees);
        
        LOGGER.info("End: testGetAllEmployees");
    }
}