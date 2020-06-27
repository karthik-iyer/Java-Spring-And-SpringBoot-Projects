package com.hrms.hrmsproject.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(rs.getInt("EmployeeID"));
        employee.setFirstName(rs.getString("FirstName"));
        employee.setLastName(rs.getString("LastName"));
        employee.setEmail(rs.getString("Email"));
        employee.setPhone(rs.getString("Phone"));
        employee.setJobTitle(rs.getString("JobTitle"));
        return employee;
    }
}
