package com.cxz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorTestController {

	
	@RequestMapping("test01")
	public String test01() {
		System.out.println("test01………………");
		return "success";
	}
}
