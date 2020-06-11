package com.demo.BatchOneJdbcFramework;

public class DatabaseQuery {

	public static String INSERT_INTO_EMPLOYEE = "insert into Employee(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, DEPT_ID, SALARY) "
			+ "values(:EMPLOYEE_ID, :FIRST_NAME, :LAST_NAME, :DEPT_ID, :SALARY )";
	
	public static String SELECT_COUNT_FROM_EMPLOYEE = "select count(*) from employee";
}
