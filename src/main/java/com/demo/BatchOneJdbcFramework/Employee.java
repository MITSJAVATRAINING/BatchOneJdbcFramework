package com.demo.BatchOneJdbcFramework;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;
	
//	String query = "insert into Employee(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, DEPT_ID, SALARY) "
//			+ "values(:EMPLOYEE_ID, :FIRST_NAME, :LAST_NAME, :DEPT_ID, :SALARY )";

	public int addEmployee() {
		
		HashMap<String, String> params = new HashMap<String, String>();
		
		//MapSqlParameterSource params = new MapSqlParameterSource();

		params.put("EMPLOYEE_ID", "4");
		params.put("FIRST_NAME", "Sai");
		params.put("LAST_NAME", "N");
		params.put("DEPT_ID", "2");
		params.put("SALARY", "30");
//		params.addValue("EMPLOYEE_ID", "3");
//		params.addValue("FIRST_NAME", "Sharan");
//		params.addValue("LAST_NAME", "S");
//		params.addValue("DEPT_ID", "3");
//		params.addValue("SALARY", "30");

		return namedJdbcTemplate.update(DatabaseQuery.INSERT_INTO_EMPLOYEE, params);
	}

	public void modifyEmployee() {

		
		int rows = jdbcTemplate.queryForObject(DatabaseQuery.SELECT_COUNT_FROM_EMPLOYEE, Integer.class);
		System.out.println("No of rows in employee table before insertion are " + rows);

		int updatedRows = addEmployee();
		System.out.println("Updated Rows are " + updatedRows);
		rows = jdbcTemplate.queryForObject(DatabaseQuery.SELECT_COUNT_FROM_EMPLOYEE, Integer.class);
		System.out.println("No of rows in employee table after insertion are " + rows);
	}
}
