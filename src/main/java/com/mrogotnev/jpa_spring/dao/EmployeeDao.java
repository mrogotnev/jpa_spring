package com.mrogotnev.jpa_spring.dao;

import com.mrogotnev.jpa_spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
    @Procedure(procedureName = "create_employee")
    Long saveProcedure(@Param("first_name") String firstName,
                       @Param("last_name") String lastName,
                       @Param("job_title") String title);

    @Procedure(procedureName = "get_all_employee")
    List<Employee> findAllProcedure();

    @Procedure(procedureName = "read_employee")
    Employee getByIdProcedure(Long id);

    @Procedure(procedureName = "read_employee_with_title")
    List<Employee> readEmployeeWithTitleProcedure(String title);

    @Procedure(procedureName = "update_employee")
    void updateEmployeeProcedure(@Param("id_empl") Long id,
                                 @Param("first_name") String firstName,
                                 @Param("last_name") String lastName,
                                 @Param("job_title") String title);

    @Procedure(procedureName = "delete_employee")
    void deleteEmployeeProcedure(Long id);
}
