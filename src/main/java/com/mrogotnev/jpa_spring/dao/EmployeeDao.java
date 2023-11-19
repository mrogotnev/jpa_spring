package com.mrogotnev.jpa_spring.dao;

import com.mrogotnev.jpa_spring.entity.Employee;
import com.mrogotnev.jpa_spring.entity.enums.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
    @Procedure(procedureName = "create_employee")
    Long procedureSave(@Param("first_name") String firstName,
                       @Param("last_name") String lastName,
                       @Param("job_title") String title);

    @Procedure(procedureName = "get_all_employee")
    List<Employee> procedureFindAll();

    @Procedure(procedureName = "read_employee")
    Employee procedureGetById(Long id);
}
