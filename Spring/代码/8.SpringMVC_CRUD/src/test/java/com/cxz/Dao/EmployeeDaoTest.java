package com.cxz.Dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cxz.bean.Employee;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDaoTest {

	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	DepartmentDao departmentDao;

	@Test
	public void testAddEmployeeByAll() {
		int addEmployee = employeeDao.addEmployee("u-001", "张三", "zhangsan@qq.com", 1, "p-001");
		System.out.println(addEmployee);
	}

	@Test
	public void testAddEmployeeByAllandDepartment() {
		int addEmployee = employeeDao.addEmployee("u-002", "李四", "李四@qq.com", 1,
				departmentDao.SelectDepartment("p-001"));
		System.out.println(addEmployee);
	}

	@Test
	public void testAddEmployeeEmployee() {
		Employee employee = new Employee("u-002", "李四", "李四@qq.com", 1, departmentDao.SelectDepartment("p-002"));
		int addEmployee = employeeDao.addEmployee(employee);
		System.out.println(addEmployee);
	}

	@Test
	public void testDeleteEmployee() {
		int deleteEmployee = employeeDao.deleteEmployee("u-492");
		System.out.println(deleteEmployee);
	}

	@Test
	public void testUpdateEmployee() {
		Employee employee = employeeDao.SelectEmployee("u-002");
		employee.setDepartment(departmentDao.SelectDepartment("p-003"));
		int updateEmployee = employeeDao.updateEmployee(employee);
		System.out.println(updateEmployee);
	}

	@Test
	public void testSelectEmployee() {
		Employee selectEmployee = employeeDao.SelectEmployee("u-0011");
		System.out.println(selectEmployee);
	}	
	
	@Test
	public void testSelectAllEmployee() {
		List<Employee> allEmployee = employeeDao.SelectAllEmployee();
		System.out.println(allEmployee);
	}
}
