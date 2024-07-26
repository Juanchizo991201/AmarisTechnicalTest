package com.jjmontenegrop.amaristest.controllers;

import com.jjmontenegrop.amaristest.exceptions.TooManyRequestsException;
import com.jjmontenegrop.amaristest.models.Employee;
import com.jjmontenegrop.amaristest.services.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @GetMapping()
    public ResponseEntity<?> getAllEmployees() {
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            return ResponseEntity.ok(employees);
        } catch (TooManyRequestsException e) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
        try {
            int employeeId = Integer.parseInt(id);
            Employee employee = employeeService.getEmployeeById(employeeId);
            if (employee != null) {
                return ResponseEntity.status(HttpStatus.OK).body(employee);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");

        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid id");
        } catch (TooManyRequestsException e) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }
}