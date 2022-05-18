package com.sampath.springbootCRUD.service;

import com.sampath.springbootCRUD.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Optional<Employee> getEmployeeById(Long id);

    public Employee updateEmployee(long id, Employee employee);

    public void deleteEmployee(long id);
}
