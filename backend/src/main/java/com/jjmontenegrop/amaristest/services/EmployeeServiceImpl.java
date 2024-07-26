package com.jjmontenegrop.amaristest.services;

import com.jjmontenegrop.amaristest.models.Employee;
import com.jjmontenegrop.amaristest.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.fetchAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.fetchEmployeeById(id);
    }
}
