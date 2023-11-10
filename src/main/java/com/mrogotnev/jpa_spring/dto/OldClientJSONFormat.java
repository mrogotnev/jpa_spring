package com.mrogotnev.jpa_spring.dto;

import lombok.Data;

@Data
public class OldClientJSONFormat {
    private Integer id;
    private String firstName;
    private String lastName;
    private String companyName;
}
