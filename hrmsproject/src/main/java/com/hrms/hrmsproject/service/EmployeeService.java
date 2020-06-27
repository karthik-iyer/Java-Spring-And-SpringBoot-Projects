package com.hrms.hrmsproject.service;

import com.hrms.hrmsproject.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public Employee findEmployeeById(int id);

    public void addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void deleteEmployee(int id);
}
