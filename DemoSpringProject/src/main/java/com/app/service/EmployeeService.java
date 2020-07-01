package com.app.service;

import com.app.dal.EmployeeDal;
import com.app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDal employeeDal;

    public List<Employee> getEmployees() {
        return employeeDal.fetchEmployees();
    }
}
