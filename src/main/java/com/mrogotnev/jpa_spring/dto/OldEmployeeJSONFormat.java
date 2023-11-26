package com.mrogotnev.jpa_spring.dto;

import com.mrogotnev.jpa_spring.entity.enums.JobTitle;
import lombok.Data;

@Data
public class OldEmployeeJSONFormat {
    private Long id;
    private String firstName;
    private String lastName;
    private JobTitle jobTitle;
}
