package com.cxz.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxz.Dao.EmployeeDao;
import com.cxz.bean.Employee;

@Controller
public class AjaxController {

	@Autowired
	EmployeeDao employeeDao;

	@ResponseBody
	@RequestMapping("/ajaxGetAllEmp")
	public List<Employee> ajaxGetAllEmp() {
		return employeeDao.SelectAllEmployee();
	}

	@RequestMapping("/testRequestBody")
	public ResponseEntity<String> testRequestBody(@RequestBody String b, HttpEntity<String> request) {
		System.out.println(b);
		System.out.println("*****************************************");
		System.out.println(request);
		String body = "<h1>success</h1>";
		MultiValueMap<String, String> headers = new HttpHeaders();
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(body, headers, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping("/downLoad")
	public ResponseEntity<byte[]> downLoad(HttpServletRequest request) {
		FileInputStream stream = null;
		try {
			// 1、获取文件下载路径（网站根路径/scripts/jquery-3.3.1.min.js
			String fileName = "jquery-3.3.1.min.js";
			String fileRoot = "scripts/";
			String realPath = request.getServletContext().getRealPath(fileRoot + fileName);
			// 2、获得文件输入流、写入到字节数组中，返回
			stream = new FileInputStream(realPath);
			byte[] buf = new byte[stream.available()];
			stream.read(buf);
			// 3、新建一个响应实体，指定响应体数据类型
			MultiValueMap<String, String> headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment;filename=" + fileName);
			return new ResponseEntity<byte[]>(buf, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@ResponseBody
	@RequestMapping("/testRequestBodyAjax")
	public Employee testRequestBodyAjax(@RequestBody Employee employee) {
		System.out.println(employee);
		return employee;
	}
}
