/*
package com.mrogotnev.jpa_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_project")
    private Integer id;
    @Column(name = "prj_name")
    private String ProjectName;
    @Column(name = "prj_status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToMany
    @JoinTable (
            name = "prj_to_employees_many_to_many",
            joinColumns = @JoinColumn(name = "id_project"),
            inverseJoinColumns = @JoinColumn(name = "id_employee")
    )
    Set<Employee> employeesOnProject;

    public Project() {
    }

    public Project(Integer id, String ProjectName, boolean status, Client client) {
        this.id = id;
        this.ProjectName = ProjectName;
        this.status = status;
        this.client = client;
    }
}
*/
