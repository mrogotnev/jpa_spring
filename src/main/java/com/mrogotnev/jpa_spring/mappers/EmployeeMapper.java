package com.mrogotnev.jpa_spring.mappers;

import com.mrogotnev.jpa_spring.dto.OldEmployeeJSONFormat;
import com.mrogotnev.jpa_spring.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee oldJsonFormatToEntityEmployee(OldEmployeeJSONFormat oldEmployeeJSONFormat) {
        Employee employee = new Employee();
        employee.setId(oldEmployeeJSONFormat.getId());
        employee.setFirstName(oldEmployeeJSONFormat.getFirstName());
        employee.setLastName(oldEmployeeJSONFormat.getLastName());
        employee.setJobTitle(oldEmployeeJSONFormat.getJobTitle());
        return employee;
    }

    public OldEmployeeJSONFormat entityEmployeeToOldJsonFormat(Employee employee) {
        OldEmployeeJSONFormat oldEmployeeJSONFormat = new OldEmployeeJSONFormat();
        oldEmployeeJSONFormat.setId(employee.getId());
        oldEmployeeJSONFormat.setFirstName(employee.getFirstName());
        oldEmployeeJSONFormat.setLastName(employee.getLastName());
        oldEmployeeJSONFormat.setJobTitle(employee.getJobTitle());
        return oldEmployeeJSONFormat;
    }
}
