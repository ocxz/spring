package com.cxz.util;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cxz.Dao.DepartmentDao;
import com.cxz.Dao.EmployeeDao;

@Component
public class Utils {

	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	DepartmentDao departmentDao;

	public String GetRandomName(String prefix) {
		switch (prefix) {
		case "p":
			while (true) {
				String did = "p-" + String.format("%03d", new Random().nextInt(999));
				if (departmentDao.SelectDepartment(did) == null) {
					return did;
				}
			}
		case "u":
			while (true) {
				String uid = "u-" + String.format("%03d", new Random().nextInt(999));
				if (employeeDao.SelectEmployee(uid) == null) {
					return uid;
				}
			}
		default:
			return null;
		}
	}
}
