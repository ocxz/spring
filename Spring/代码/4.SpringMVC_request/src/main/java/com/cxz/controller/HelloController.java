package com.cxz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/hello")
	public String handle0() {
		return "success";
	}

	@RequestMapping(value = "/handle01")
	public String handle01(@RequestParam(value = "userName", defaultValue = "程老板", required = true) String name,
			@RequestHeader("User-Agent") String userAgent, @CookieValue("JSESSIONID")String cookie) {
		System.out.println(name);
		System.out.println(userAgent);
		System.out.println(cookie);
		return "success";
	}
	
	@RequestMapping(value="/handle02")
	public String handle02(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		req.setAttribute("r1", "我是请求域的");
		session.setAttribute("s1", "我是session域的");
		return "success";
	}
}
