package com.mrogotnev.jpa_spring.services;

import com.mrogotnev.jpa_spring.dao.EmployeeDao;
import com.mrogotnev.jpa_spring.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmployeeService {
    private EmployeeDao employeeDao;

    public Long createEmployee(Employee employee) {
        return employeeDao.save(employee).getId();
    }
}
