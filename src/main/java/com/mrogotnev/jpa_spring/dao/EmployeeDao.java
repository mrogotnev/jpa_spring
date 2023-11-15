package com.mrogotnev.jpa_spring.dao;

import com.mrogotnev.jpa_spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
    @Procedure(procedureName = "create_employee")
    Employee save(Employee employee);
}
