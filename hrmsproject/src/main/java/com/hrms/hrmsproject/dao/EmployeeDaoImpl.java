package com.hrms.hrmsproject.dao;

import com.hrms.hrmsproject.model.Employee;
import com.hrms.hrmsproject.model.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAllEmployees() {
        String query = "Select * from Employee";
        RowMapper<Employee> rowMapper = new EmployeeRowMapper();
        List<Employee> list = jdbcTemplate.query(query,rowMapper);

        return list;
    }

    @Override
    public Employee findEmployeeById(int id) {
        String query = "Select * from Employee where EmployeeID = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(query,rowMapper,id);

        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        String query = "Insert into Employee(FirstName, LastName, Email, Phone, JobTitle) Values (?,?,?,?,?)";
        jdbcTemplate.update(query,employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getPhone(),employee.getJobTitle());
    }

    @Override
    public void updateEmployee(Employee employee) {
        String query = "Update Employee set FirstName = ? , LastName = ? , Email = ?, Phone  = ?, JobTitle = ? Where EmployeeId = ?";
        jdbcTemplate.update(query,employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getPhone(),employee.getJobTitle(),employee.getEmployeeId());
    }

    @Override
    public void deleteEmployee(int id) {
        String query = "Delete from Employee where EmployeeID = ?";
        jdbcTemplate.update(query,id);
    }
}
