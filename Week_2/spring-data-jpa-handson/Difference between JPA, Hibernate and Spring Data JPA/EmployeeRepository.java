package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.ormlearn.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // No code needed! Spring automatically generates implementation at runtime
    // for save(), findById(), findAll(), deleteById(), etc.
}