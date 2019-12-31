package com.cxz.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cxz.Dao.DepartmentDao;
import com.cxz.Dao.EmployeeDao;
import com.cxz.bean.Department;
import com.cxz.bean.Employee;
import com.cxz.util.Utils;

@Controller
public class EmpController {

	@Autowired
	DepartmentDao departmentDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	Utils utils;

	@RequestMapping("/show")
	public String show(Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("emps", employeeDao.SelectAllEmployee());
		session.setAttribute("util", utils);
		session.setAttribute("ctp", request.getContextPath());
		return "list";
	}

	@RequestMapping("/addpage")
	public String toAddPage(Model model,Employee employee) {
		employee.setUid(utils.GetRandomName("u"));
		model.addAttribute("deps", departmentDao.SelectAllDepartment());
		return "add2";
	}

	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public String add(@Valid Employee employee, BindingResult result, Model model
			, HttpServletRequest request) {
		if(result.hasErrors()) {
			Map<String, String> errorInfo = utils.getErrorInfo(result,request);
//			model.addAttribute("errorInfo", utils.replaceErrorInfo("birthday", "Unable to parse", 
//					"日期格式不正确（yyyy-MM-dd）", errorInfo));
			model.addAttribute("errorInfo", errorInfo);
			model.addAttribute("deps", departmentDao.SelectAllDepartment());
			return "add2";
		}
		if (employeeDao.addEmployee(employee) == 0) {
			return "error";
		}
		return "redirect:/show";
	}
	
	/**
	 * 快速添加
	 * 发送的完整请求是：/quickadd?empinfo=王五&1&wangwu@qq.com&p-001
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/quickadd")
	public String quickAdd(@RequestParam("empinfo")Employee employee) {
//		System.out.println(employee);
		if(employeeDao.addEmployee(employee)==0) {
			return "error";
		}
		return "redirect:/show";
	}
	

	@RequestMapping(value = "/emp/{uid}", method = RequestMethod.GET)
	public String detail(@PathVariable("uid") String uid, Model model) {
		Employee employee = employeeDao.SelectEmployee(uid);
		if (employee == null) {
			return "error";
		}
		model.addAttribute("emp", employee);
		return "detail";
	}

	@RequestMapping(value = "/update/{uid}", method = RequestMethod.GET)
	public String updatePage(@PathVariable("uid") String uid, Model model) {
		Employee employee = employeeDao.SelectEmployee(uid);
		List<Department> allDepartment = departmentDao.SelectAllDepartment();
		if (employee == null || allDepartment == null) {
			return "error";
		}
		model.addAttribute("employee", employee);
		model.addAttribute("depts", allDepartment);
		return "edit";
	}
	
	@RequestMapping(value = "/emp/{uid}", method = RequestMethod.PUT)
	public String update(Employee employee) {
		if (employee == null || employeeDao.updateEmployee(employee) == 0) {
			return "error";
		}
		return "redirect:/show";
	}
	
	@RequestMapping(value="/emp/{uid}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("uid")String uid) {
		if(employeeDao.deleteEmployee(uid)==0) {
			return "error";
		}
		return "redirect:/show";
	}
}
