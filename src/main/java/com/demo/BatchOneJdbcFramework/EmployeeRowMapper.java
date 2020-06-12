package com.demo.BatchOneJdbcFramework;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
		employee.setFirstName(rs.getString("FIRST_NAME"));
		employee.setLastName(rs.getString("LAST_NAME"));
		employee.setDeptId(rs.getInt("DEPT_ID"));
		employee.setSalary(rs.getLong("SALARY"));
		return employee;
	}

}
