package com.mrogotnev.jpa_spring.controller;

import com.mrogotnev.jpa_spring.entity.Employee;
import com.mrogotnev.jpa_spring.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public Long createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
}
