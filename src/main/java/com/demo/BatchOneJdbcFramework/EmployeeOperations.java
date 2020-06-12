package com.demo.BatchOneJdbcFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

@Component
public class EmployeeOperations implements EmployeeOperationsInterface {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

//	String query = "insert into Employee(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, DEPT_ID, SALARY) "
//			+ "values(:EMPLOYEE_ID, :FIRST_NAME, :LAST_NAME, :DEPT_ID, :SALARY )";
	
	public void addEmployees() {
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		
		Employee emp1 = new Employee();
		emp1.setEmployeeId(5);
		emp1.setFirstName("James");
		emp1.setLastName("K");
		emp1.setDeptId(4);
		emp1.setSalary(100);
		
		employeeList.add(emp1);
		
		
		Employee emp2 = new Employee();
		emp2.setEmployeeId(6);
		emp2.setFirstName("Ross");
		emp2.setLastName("K");
		emp2.setDeptId(3);
		emp2.setSalary(200);
		
		employeeList.add(emp2);
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(employeeList);
		
		String query = "insert into employee values(:employeeId, :firstName, :lastName, :deptId, :salary)";
		
		namedJdbcTemplate.batchUpdate(query, params);
	}

	public int addEmployee() {

		HashMap<String, String> params = new HashMap<String, String>();

		// MapSqlParameterSource params = new MapSqlParameterSource();
		params.put("EMPLOYEE_ID", "4");
		params.put("FIRST_NAME", "Sai");
		params.put("LAST_NAME", "N");
		params.put("DEPT_ID", "2");
		params.put("SALARY", "30");

		return namedJdbcTemplate.update(DatabaseQuery.INSERT_INTO_EMPLOYEE, params);
	}
	
	public void readCountOfEmployee() {
		int rows = jdbcTemplate.queryForObject(DatabaseQuery.SELECT_COUNT_FROM_EMPLOYEE, Integer.class);
		System.out.println("No of rows in employee table are " + rows);
	}

	public void readEmployeeById(String id) {
		String query = "SELECT * from Employee where Employee_Id = :id";
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		Employee emp = namedJdbcTemplate.queryForObject(query, params, new EmployeeRowMapper());
		printEmployee(emp);
	}

	public void readEmployee() {
		String query = "SELECT * from Employee";
		List<Employee> employeeList = jdbcTemplate.query(query, new EmployeeRowMapper());

		System.out.println(" Employees are ");
		for (Employee emp : employeeList) {
			printEmployee(emp);
		}
	}
	
	public void printEmployee(Employee emp) {
		System.out.print(" Employee Id -> " + emp.getEmployeeId());
		System.out.print(" First Name -> " + emp.getFirstName());
		System.out.print(" Last Name -> " + emp.getLastName());
		System.out.print(" Depatment Id -> " + emp.getDeptId());
		System.out.println(" Salary -> " + emp.getSalary());
	}
	
	public void modifyEmployee() {
		//readEmployeeById("3");
		addEmployees();
	}
}
//
//class EmployeeRowMapper implements RowMapper<Employee> {
//	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
//		Employee employee = new Employee();
//		employee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
//		employee.setFirstName(rs.getString("FIRST_NAME"));
//		employee.setLastName(rs.getString("LAST_NAME"));
//		employee.setDeptId(rs.getInt("DEPT_ID"));
//		employee.setSalary(rs.getLong("SALARY"));
//		return employee;
//	}
//}
