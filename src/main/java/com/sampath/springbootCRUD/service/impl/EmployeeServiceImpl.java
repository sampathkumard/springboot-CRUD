package com.sampath.springbootCRUD.service.impl;

import com.sampath.springbootCRUD.entity.Employee;
import com.sampath.springbootCRUD.exception.ResourceNotFoundException;
import com.sampath.springbootCRUD.repository.EmployeeRepository;
import com.sampath.springbootCRUD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){
        return Optional.ofNullable(employeeRepository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("Employee", "id", id)));
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        Employee existEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","id",id));
        /////updating existEmployee with the client given details
        existEmployee.setFirstName(employee.getFirstName());
        existEmployee.setLastName(employee.getLastName());
        existEmployee.setEmail(employee.getEmail());
        ////Saving the existEmployee
        employeeRepository.save(existEmployee);
        return existEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));
         employeeRepository.deleteById(id);
    }
}
