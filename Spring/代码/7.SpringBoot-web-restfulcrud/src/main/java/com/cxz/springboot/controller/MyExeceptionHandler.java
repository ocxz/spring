package com.cxz.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cxz.springboot.exception.UserNotExistException;

@ControllerAdvice
public class MyExeceptionHandler {

	@ExceptionHandler(UserNotExistException.class)
	public Map<String, Object> handleException(Exception e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "用户不rfasd存在");
		map.put("message", e.getMessage());
		return map;
	}
}
