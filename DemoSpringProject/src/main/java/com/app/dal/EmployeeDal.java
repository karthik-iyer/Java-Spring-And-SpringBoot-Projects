package com.app.dal;
import com.app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class EmployeeDal {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> fetchEmployees() {
       return jdbcTemplate.query("select ID, FirstName, LastName from Employee", new RowMapper<Employee>()
        {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee employee = new Employee();
                employee.setId(rs.getLong("ID"));
                employee.setFirstName(rs.getString("FirstName"));
                employee.setLastName(rs.getString("LastName"));
                return employee;
            }
        });

    }

    @Transactional
    public void AddEmployee(Employee employee){
      jdbcTemplate.update("insert into Employee (FirstName, LastName) values (?, ?)",employee.getFirstName(),employee.getLastName());
    }

    @Transactional
    public void UpdateEmployee(Employee employee){
        jdbcTemplate.update("update Employee set FirstName = ? , LastName = ? where ID = ? ",employee.getFirstName(),employee.getLastName(),employee.getId());
    }

    @Transactional
    public void DeleteEmployee(int id){
        jdbcTemplate.update("delete from Employee where ID = ? ",id);
    }

}
