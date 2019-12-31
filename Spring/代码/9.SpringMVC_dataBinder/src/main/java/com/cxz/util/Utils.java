package com.cxz.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.support.RequestContext;

import com.cxz.Dao.DepartmentDao;
import com.cxz.Dao.EmployeeDao;

@Component
public class Utils {

	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	DepartmentDao departmentDao;
	@Autowired
	SimpleDateFormat sdf;
	@Autowired
	PropertiesFileHandle pfh;

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

	public String dateFormat(Date date) {
		try {
			return sdf.format(date);
		} catch (Exception e) {
			return "";
		}
	}

	public Map<String, String> replaceErrorInfo(String oldInfo, String newInfo, Map<String, String> errors) {
		if (errors == null || errors.size() == 0) {
			return errors;
		}
		for (String key : errors.keySet()) {
			if (errors.get(key).contains(oldInfo)) {
				errors.replace(key, newInfo);
			}
		}
		return errors;
	}

	public Map<String, String> replaceErrorInfo(String key, String oldInfo, String newInfo,
			Map<String, String> errors) {
		if (errors == null || errors.size() == 0) {
			return errors;
		}
		if (errors.containsKey(key) && errors.get(key).contains(oldInfo)) {
			errors.replace(key, newInfo);
		}
		return errors;
	}

	/**
	 * 根据错误结果，获取错误（如果一个字段有多个错误，则返回优先级最高的
	 * 
	 * @param result
	 * @return
	 */
	public Map<String, String> getErrorInfo(BindingResult result) {
		return getErrorInfo(result, null);
	}

	// 获取错误（国际化配置）
	public Map<String, String> getErrorInfo(BindingResult result, HttpServletRequest request) {
		if (!result.hasErrors()) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		Map<String, Integer> codes = new HashMap<String, Integer>();
		List<FieldError> errors = result.getFieldErrors();
		for (FieldError fieldError : errors) {
			String errorName = fieldError.getField();
			String code = fieldError.getCode();
			// 如果map中没有，或者是存在优先级更高的，则替换
			if (!map.containsKey(errorName) || codes.get(errorName) > pfh.getIntValue(code)) {
				codes.put(errorName, pfh.getIntValue(code));
				// 获取国际化错误信息
				String msg = request == null ? "" : getMessage(request, fieldError);
				if (msg == null || msg == "") {
					msg = fieldError.getDefaultMessage();
				} 
				map.put(errorName, msg);
			}
		}
		return map;
	}

	/**
	 * 根据key，从国际化配置文件中获得value
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	public String getMessage(HttpServletRequest request, String key) {
		try {
			RequestContext requestContext = new RequestContext(request);
			return requestContext.getMessage(key);
		} catch (NoSuchMessageException e) {
			return "";
		}
	}

	public String getMessage(HttpServletRequest request, FieldError fieldError) {
		for (String code : fieldError.getCodes()) {
			String msg = getMessage(request, code);
			if(msg!=null && msg!="") {
				System.out.println(msg);
				return msg;
			}
		}
		return "";
	}
}
