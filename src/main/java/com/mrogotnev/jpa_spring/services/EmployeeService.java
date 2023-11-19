package com.mrogotnev.jpa_spring.services;

import com.mrogotnev.jpa_spring.dao.EmployeeDao;
import com.mrogotnev.jpa_spring.entity.Employee;
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
        return employeeDao.procedureSave(employee.getFirstName(), employee.getLastName(), employee.getJobTitle().toString());
    }
    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDao.procedureFindAll();
    }
    @Transactional
    public Employee readEmployee(Long id) {
        return employeeDao.procedureGetById(id);
    }
}
