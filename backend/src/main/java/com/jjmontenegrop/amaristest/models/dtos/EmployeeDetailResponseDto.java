package com.jjmontenegrop.amaristest.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jjmontenegrop.amaristest.models.Employee;
import lombok.Data;

@Data
public class EmployeeDetailResponseDto {

    @JsonProperty("status")
    private String status;

    @JsonProperty("data")
    private Employee data;

    @JsonProperty("message")
    private String message;
}
