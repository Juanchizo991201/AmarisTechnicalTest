package com.jjmontenegrop.amaristest.models.dtos;

import com.jjmontenegrop.amaristest.models.Employee;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeResponseDto {

    private String status;
    private List<Employee> data;
}
