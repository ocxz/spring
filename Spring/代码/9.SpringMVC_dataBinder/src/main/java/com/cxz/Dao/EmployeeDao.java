package com.cxz.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cxz.bean.Department;
import com.cxz.bean.Employee;
import com.cxz.util.Utils;

@Repository
public class EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	DepartmentDao departmentDao;
	@Autowired
	Utils utils;

	public int addEmployee(String uid, String lastName, Date birthday, String email, Integer gender, String did) {
		if (uid == null || !uid.startsWith("u")) {
			uid = utils.GetRandomName("u");
		}
		if (SelectEmployee(uid) != null) {
			return 0;
		}
		String sql = "INSERT INTO employee(uid, lastName,birthday,email,gender,did) VALUES(?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, uid, lastName, birthday, email, gender, did);
	}

	public int addEmployee(String uid, String lastName, Date birthday, String email, Integer gender,
			Department department) {
		return addEmployee(uid, lastName, birthday, email, gender, department.getDid());
	}

	public int addEmployee(Employee employee) {
		return addEmployee(employee.getUid(), employee.getLastName(), employee.getBirthday(), employee.getEmail(),
				employee.getGender(), employee.getDepartment());
	}

	public int deleteEmployee(String uid) {
		String sql = "DELETE FROM employee WHERE uid=?";
		return jdbcTemplate.update(sql, uid);
	}

	public int updateEmployee(Employee employee) {
		String sql = "UPDATE employee SET uid=?,lastName=?,birthday=?,email=?,gender=?,did=? where uid=?";
		return jdbcTemplate.update(sql, employee.getUid(), employee.getLastName(), employee.getBirthday(),
				employee.getEmail(), employee.getGender(), employee.getDepartment().getDid(), employee.getUid());
	}

	public Employee SelectEmployee(String uid) {
		String sql = "SELECT id,uid,lastName,birthday,email,gender FROM employee WHERE uid=?";
		String sql1 = "SELECT did FROM employee WHERE uid=?";
		try {
			Employee employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), uid);
			String did = jdbcTemplate.queryForObject(sql1, String.class, uid);
			employee.setDepartment(departmentDao.SelectDepartment(did));
			return employee;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Employee> SelectAllEmployee() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT uid FROM employee";
		try {
			List<String> uids = jdbcTemplate.queryForList(sql, String.class);
			for (String uid : uids) {
				employees.add(SelectEmployee(uid));
			}
			return employees;
		} catch (Exception e) {
			return null;
		}
	}
}
