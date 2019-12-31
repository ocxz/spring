package com.cxz.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.cxz.Dao.DepartmentDao;
import com.cxz.bean.Employee;

/**
 * 自定义类型转换器，将String --> 转换为 Employee对象
 * 实现Converter<S,T>，需要知道两个泛型：S（source）--> T（target目标类型）
 * @author 22527
 *
 */
public class StringToEmployeeConverter implements Converter<String, Employee>{

	@Autowired
	DepartmentDao departmentDao;
	
	@Override
	public Employee convert(String source) {
		// source就是页面提交过来，需要转换的字符串
		// 王五&1&wangwu@qq.com&p-001
//		System.out.println("员工的字符串信息：" + source);
		if(source != null && source.contains("&")) {
			Employee employee = new Employee();
			String[] split = source.split("&");
			employee.setLastName(split[0]);
			employee.setGender(Integer.parseInt(split[1]));
			employee.setEmail(split[2]);
			employee.setDepartment(departmentDao.SelectDepartment(split[3]));
			return employee;
		}
		return null;
	}
}
