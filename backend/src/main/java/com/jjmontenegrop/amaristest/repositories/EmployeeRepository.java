package com.jjmontenegrop.amaristest.repositories;

import com.jjmontenegrop.amaristest.models.Employee;
import com.jjmontenegrop.amaristest.models.dtos.EmployeeDetailResponseDto;
import com.jjmontenegrop.amaristest.models.dtos.EmployeeResponseDto;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Builder
@Repository
@RequiredArgsConstructor
public class EmployeeRepository {

    private static final String BASE_URL = "http://dummy.restapiexample.com/api/v1";
    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable(value = "employees")
    public List<Employee> fetchAllEmployees() {
        String url = BASE_URL + "/employees";

            EmployeeResponseDto response = restTemplate.getForObject(url, EmployeeResponseDto.class);
            return response != null ? response.getData() : Collections.emptyList();


    }

    @Cacheable(value = "employee", key = "#id")
    public Employee fetchEmployeeById(int id) {
        String url = BASE_URL + "/employee/" + id;

            EmployeeDetailResponseDto response = restTemplate.getForObject(url, EmployeeDetailResponseDto.class);
            return response != null ? response.getData() : null;

    }
}