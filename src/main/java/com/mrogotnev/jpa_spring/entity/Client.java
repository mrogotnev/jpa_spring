package com.mrogotnev.jpa_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "clients")
public class Client extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_client")
    private Integer id;
    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "client")
    Set<Project> projectSet;

    public Client() {
    }
    public Client(String firstName, String lastName, String companyName) {
        super(firstName, lastName);
        this.companyName = companyName;
    }
}
