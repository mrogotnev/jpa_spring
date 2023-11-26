package com.mrogotnev.jpa_spring.services;

import com.mrogotnev.jpa_spring.dao.EmployeeDao;
import com.mrogotnev.jpa_spring.dto.OldEmployeeJSONFormat;
import com.mrogotnev.jpa_spring.entity.Employee;
import com.mrogotnev.jpa_spring.entity.enums.JobTitle;
import com.mrogotnev.jpa_spring.mappers.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class EmployeeService {
    private EmployeeDao employeeDao;
    private EmployeeMapper employeeMapper;

    @Transactional
    public Long createEmployee(OldEmployeeJSONFormat oldEmployeeJSONFormat) {
        Employee employee = employeeMapper.oldJsonFormatToEntityEmployee(oldEmployeeJSONFormat);
        return employeeDao.saveProcedure(employee.getFirstName(), employee.getLastName(), employee.getJobTitle().toString());
    }

    @Transactional
    public List<OldEmployeeJSONFormat> getAllEmployee() {
        List<Employee> employees = employeeDao.findAllProcedure();
        List<OldEmployeeJSONFormat> oldEmplFormatList = new ArrayList<>();
        for (Employee employee : employees) {
            oldEmplFormatList.add(employeeMapper.entityEmployeeToOldJsonFormat(employee));
        }
        return oldEmplFormatList;
    }

    @Transactional
    public OldEmployeeJSONFormat readEmployee(Long id) {
        return employeeMapper.entityEmployeeToOldJsonFormat(employeeDao.getByIdProcedure(id));
    }

    @Transactional
    public List<OldEmployeeJSONFormat> readEmployeeWithTitle(JobTitle jobTitle) {
        List<Employee> employees = employeeDao.readEmployeeWithTitleProcedure(jobTitle.toString());
        List<OldEmployeeJSONFormat> oldEmplFormatList = new ArrayList<>();
        for (Employee employee : employees) {
            oldEmplFormatList.add(employeeMapper.entityEmployeeToOldJsonFormat(employee));
        }
        return oldEmplFormatList;
    }

    @Transactional
    public void updateEmployee(Long id, OldEmployeeJSONFormat oldEmployeeJSONFormat) {
        Employee employee = employeeMapper.oldJsonFormatToEntityEmployee(oldEmployeeJSONFormat);
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
