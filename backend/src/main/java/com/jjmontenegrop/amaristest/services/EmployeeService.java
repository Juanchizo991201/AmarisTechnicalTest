package com.jjmontenegrop.amaristest.services;

import com.jjmontenegrop.amaristest.models.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);
}
