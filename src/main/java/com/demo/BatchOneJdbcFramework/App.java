package com.demo.BatchOneJdbcFramework;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        
       // DataSource dataSource  = (DataSource)context.getBean("dataSource");
        
        JdbcTemplate template =  (JdbcTemplate)context.getBean("jdbcTemplate");
        
       // JdbcTemplate template = new JdbcTemplate(dataSource);
        
        String query = "select count(*) from emp";
        
        int rows = template.queryForObject(query, Integer.class);
        
        System.out.println("rows in employee table " + rows);
    }
}
