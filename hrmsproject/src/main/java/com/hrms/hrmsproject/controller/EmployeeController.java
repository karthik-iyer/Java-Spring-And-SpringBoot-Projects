package com.hrms.hrmsproject.controller;

import com.hrms.hrmsproject.model.Employee;
import com.hrms.hrmsproject.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping(path="/", produces = "application/json")
    public List<Employee> getEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public Employee getEmployeeById(@PathVariable int id)
    {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping(path="/", consumes = "application/json", produces = "application/json")
    public ResponseEntity addEmployee(@RequestBody Employee employee)
    {
         employeeService.addEmployee(employee);
         return new ResponseEntity(employee, HttpStatus.CREATED);
    }

    @PostMapping(path="/Update", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateEmployee(@RequestBody Employee employee)
    {
        employeeService.updateEmployee(employee);
        return new ResponseEntity(employee, HttpStatus.NO_CONTENT);
    }

    @PostMapping(path="/Delete/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity deleteEmployee(@PathVariable int id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
