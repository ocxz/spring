package com.cxz.springboot.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxz.springboot.exception.UserNotExistException;

@Controller
public class HelloController {

	//@RequestMapping({"/","index.html"})
	public String index() {
		return "login";
	}
	
	@ResponseBody
	@RequestMapping("hello")
	public String hello(@RequestParam("user") String user, Model model) {
		if(!user.equals("cxz")) {
			throw new UserNotExistException();
		}
		model.addAttribute("user", "cxz");
		return "hello world";
	}
	
	@RequestMapping("success")
	public String success(Model model) {
		// 自动找：classpath:/templates/success.html
		model.addAttribute("hello", "<h1>你好<h1>");
		model.addAttribute("users", Arrays.asList("张三","李四","王五"));
		return "success";
	}
}
