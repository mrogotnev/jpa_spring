package com.mrogotnev.jpa_spring.services;

import com.mrogotnev.jpa_spring.dao.EmployeeDao;
import com.mrogotnev.jpa_spring.entity.Employee;
import com.mrogotnev.jpa_spring.entity.enums.JobTitle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@AllArgsConstructor
public class EmployeeService {
    private EmployeeDao employeeDao;

    @Transactional
    public Long createEmployee(Employee employee) {
        return employeeDao.saveProcedure(employee.getFirstName(), employee.getLastName(), employee.getJobTitle().toString());
    }
    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDao.findAllProcedure();
    }
    @Transactional
    public Employee readEmployee(Long id) {
        return employeeDao.getByIdProcedure(id);
    }

    @Transactional
    public List<Employee> readEmployeeWithTitle(JobTitle jobTitle) {
        return employeeDao.readEmployeeWithTitleProcedure(jobTitle.toString());
    }

    @Transactional
    public void updateEmployee(Long id, Employee employee) {
        employeeDao.updateEmployeeProcedure(id,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle().toString());
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeDao.deleteEmployeeProcedure(id);
    }
}
