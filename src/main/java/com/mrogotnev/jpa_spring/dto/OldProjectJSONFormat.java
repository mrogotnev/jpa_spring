package com.mrogotnev.jpa_spring.dto;

import lombok.Data;

@Data
public class OldProjectJSONFormat {
    private String projectName;
    private boolean status;
    private int clientId;
}
