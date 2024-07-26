package com.jjmontenegrop.amaristest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @JsonProperty("id")
    private int id;

    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("employee_salary")
    private int employeeSalary;

    @JsonProperty("employee_age")
    private int employeeAge;

    @JsonProperty("profile_image")
    private String profileImage;

    @JsonProperty("employee_annual_salary")
    public int getEmployeeAnnualSalary() {
        return this.employeeSalary * 12;
    }
}
