package com.mrogotnev.jpa_spring.controller;

import com.mrogotnev.jpa_spring.dto.OldEmployeeJSONFormat;
import com.mrogotnev.jpa_spring.entity.Employee;
import com.mrogotnev.jpa_spring.entity.enums.JobTitle;
import com.mrogotnev.jpa_spring.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public List<OldEmployeeJSONFormat> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/readEmployee/{id}")
    public OldEmployeeJSONFormat readEmployee(@PathVariable Long id) {
        return employeeService.readEmployee(id);
    }

    @GetMapping("/readEmployeeWithTitle/{title}")
    public List<OldEmployeeJSONFormat> readEmployeeWithTitle(@PathVariable JobTitle title) {
        return employeeService.readEmployeeWithTitle(title);
    }

    @PostMapping("/createEmployee")
    public Long createEmployee(@RequestBody OldEmployeeJSONFormat employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/updateEmployee/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody OldEmployeeJSONFormat employee) {
        employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
