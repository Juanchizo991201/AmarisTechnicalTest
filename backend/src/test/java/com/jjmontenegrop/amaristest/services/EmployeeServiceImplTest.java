package com.jjmontenegrop.amaristest.services;

import com.jjmontenegrop.amaristest.models.Employee;
import com.jjmontenegrop.amaristest.models.dtos.EmployeeResponseDto;
import com.jjmontenegrop.amaristest.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        Employee employee1 = new Employee(1, "John Doe", 56700, 24, "");
        Employee employee2 = new Employee(2, "Jane Doe", 56700, 24, "");
        List<Employee> mockEmployees = Arrays.asList(employee1, employee2);

        EmployeeResponseDto mockResponse = new EmployeeResponseDto();
        mockResponse.setData(mockEmployees);

        // Mock the employeeRepository's methods
        when(employeeRepository.fetchAllEmployees()).thenReturn(mockEmployees);
        when(employeeRepository.fetchEmployeeById(anyInt())).thenReturn(employee1);
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();

        assertEquals(2, employees.size());
        assertEquals(1, employees.get(0).getId());
        assertEquals("John Doe", employees.get(0).getEmployeeName());
        assertEquals(56700, employees.get(0).getEmployeeSalary());
        assertEquals(24, employees.get(0).getEmployeeAge());
        assertEquals("", employees.get(0).getProfileImage());
        assertEquals(56700 * 12, employees.get(0).getEmployeeAnnualSalary());

        assertEquals(2, employees.get(1).getId());
        assertEquals("Jane Doe", employees.get(1).getEmployeeName());
        assertEquals(56700, employees.get(1).getEmployeeSalary());
        assertEquals(24, employees.get(1).getEmployeeAge());
        assertEquals("", employees.get(1).getProfileImage());
        assertEquals(56700 * 12, employees.get(1).getEmployeeAnnualSalary());
    }

    @Test
    void testGetEmployeeById() {
        Employee employee = employeeService.getEmployeeById(1);

        assertEquals(1, employee.getId());
        assertEquals("John Doe", employee.getEmployeeName());
        assertEquals(56700, employee.getEmployeeSalary());
        assertEquals(24, employee.getEmployeeAge());
        assertEquals("", employee.getProfileImage());
        assertEquals(56700 * 12, employee.getEmployeeAnnualSalary());
    }
}
