package com.mrogotnev.jpa_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_project", nullable = false)
    private Integer id;
    @Column(name = "prj_name", nullable = false)
    private String ProjectName;
    @Column(name = "prj_status", nullable = false)
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    /*@ManyToMany
    @JoinTable (
            name = "prj_to_employees_many_to_many",
            joinColumns = @JoinColumn(name = "id_project"),
            inverseJoinColumns = @JoinColumn(name = "id_employee")
    )
    Set<Employee> employeesOnProject;*/

    public Project() {
    }

    public Project(Integer id, String ProjectName, boolean status, Client client) {
        this.id = id;
        this.ProjectName = ProjectName;
        this.status = status;
        this.client = client;
    }
}
