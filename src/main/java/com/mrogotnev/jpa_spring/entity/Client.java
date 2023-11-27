package com.mrogotnev.jpa_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clients")
public class Client extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;
    @Column(name = "company_name")
    private String companyName;


    public Client() {
    }

    public Client(String firstName, String lastName, String companyName) {
        super(firstName, lastName);
        this.companyName = companyName;
    }
}
