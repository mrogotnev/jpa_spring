/*
package com.mrogotnev.jpa_spring.entity;

import com.mrogotnev.jpa_spring.entity.enums.JobTitle;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "employees")
public class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_employee")
    private Integer id;
    @Column(name = "job_title")
    private JobTitle jobTitle;

    @ManyToMany(mappedBy = "employeesOnProject")
    Set<Project> projectsCurrentEmployee;
    public Employee(String firstName, String lastName, JobTitle jobTitle) {
        super(firstName, lastName);
        this.jobTitle = jobTitle;
    }
}*/
