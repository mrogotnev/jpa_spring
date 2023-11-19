package com.mrogotnev.jpa_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Person {
    private String firstName;
    @Column(name = "second_name")
    private String lastName;
    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
