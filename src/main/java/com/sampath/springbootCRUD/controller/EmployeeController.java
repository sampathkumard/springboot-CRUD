package com.sampath.springbootCRUD.controller;

import com.sampath.springbootCRUD.entity.Employee;
import com.sampath.springbootCRUD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }
    ///get all employees from database
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    ////by id
    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") long id){
        return employeeService.getEmployeeById(id);

    }
    ////update employee Rest Api
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
         employeeService.deleteEmployee(id);
         return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);

    }
}
