package com.demo.BatchOneJdbcFramework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("spring.xml");

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Employee emp = context.getBean(Employee.class);
		emp.modifyEmployee();

		// JdbcTemplate template = (JdbcTemplate)context.getBean("jdbcTemplate");

		// JdbcTemplate template = new JdbcTemplate(dataSource);

		// String query = "select count(*) from emp";

		// int rows = template.queryForObject(query, Integer.class);

		// System.out.println("rows in employee table " + rows);
	}
}
