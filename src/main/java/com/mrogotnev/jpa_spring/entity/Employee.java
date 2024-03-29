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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Long id;
    @Column(name = "job_title", columnDefinition = "ENUM('Developer', 'Tester', 'Admin', 'Manager')")
    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;

    @ManyToMany
    @JoinTable(
            name = "prj_to_employees_many_to_many",
            joinColumns = @JoinColumn(name = "id_employee"),
            inverseJoinColumns = @JoinColumn(name = "id_project")
    )
    Set<Project> projectsCurrentEmployee;

    public Employee() {
    }

    public Employee(String firstName, String lastName, JobTitle jobTitle) {
        super(firstName, lastName);
        this.jobTitle = jobTitle;
    }
}
