package com.cxz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cxz.bean.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int saveEmployee(Employee employee) {
		String sql = "Insert into  employee(emp_name, salary) values(?,?)";
		return jdbcTemplate.update(sql, employee.getEmployeedName(), employee.getSalary());
	}
}
