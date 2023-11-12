package com.mrogotnev.jpa_spring.dto;

import lombok.Data;

@Data
public class OldProjectJSONFormat {
    private Long id;
    private String projectName;
    private boolean status;
    private Long clientId;
}
