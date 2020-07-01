package com.app.controller;
import com.app.model.Employee;
import com.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path ={"/", ""})
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping(path={"/",""})
    public void AddEmployee(@RequestBody Employee employee){
        employeeService.AddEmployee(employee);
    }

    @PutMapping(path={"/",""})
    public void UpdateEmployee(@RequestBody Employee employee){
        employeeService.UpdateEmployee(employee);
    }

    @DeleteMapping(path="/{id}")
    public void DeleteEmployee(@PathVariable int id){
        employeeService.DeleteEmployee(id);
    }


}
