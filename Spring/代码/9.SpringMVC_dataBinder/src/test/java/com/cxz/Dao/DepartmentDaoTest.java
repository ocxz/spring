package com.cxz.Dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cxz.bean.Department;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentDaoTest {

	@Autowired
	DepartmentDao departmentDao;

	@Test
	public void testAddDepartment() {
		int addDepartment = departmentDao.addDepartment("p-002", ".NET开发二组");
		System.out.println(addDepartment);
	}

	@Test
	public void testAddDepartmentByObject() {
		Department department = new Department("p-003","JAVA开发一组");
		int addDepartment = departmentDao.addDepartment(department);
		System.out.println(addDepartment);
	}

	@Test
	public void testDeleteDepartment() {
		int deleteDepartment = departmentDao.deleteDepartment("p-002");
		System.out.println(deleteDepartment);
	}

	@Test
	public void testUpdateDepartment() {
		Department department = departmentDao.SelectDepartment("p-001");
		department.setDepartmentName(".NET实习一组");
		departmentDao.updateDepartment(department);
	}
	
	@Test
	public void testSelectDepartment() {
		Department selectDepartment = departmentDao.SelectDepartment("p-001");
		System.out.println(selectDepartment);
	}
	
	@Test
	public void testSelectAllDepartment() {
		List<Department> allDepartment = departmentDao.SelectAllDepartment();
		System.out.println(allDepartment);
	}
}
