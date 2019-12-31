package com.cxz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	/**
	 * 使用相对路径拼串
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello() {
		
		// 拼接的URL：/WEB-INF/pages/../../hello.jsp
		// 即--> /hello.jsp
		return "../../hello";
	}
	
	/**
	 * forward:代表直接转发到 /hello.jsp中
	 * 不会经过拼串的过程
	 * forward:后面的路径，一定要加/，表示根路径下的绝对路径，如果不加/表示相对路径，容易出问题
	 * @return
	 */
	@RequestMapping("/handle01")
	public String handle01() {
		System.out.println("handle01");
		return "forward:/hello.jsp";
	}
	
	/**
	 * forward:也可转发到控制器中，由控制器在转发到目标页面中，实现页面展示前的多次转发控制处理
	 * @return
	 */
	@RequestMapping("/handle02")
	public String handle02() {
		System.out.println("handle02");
		return "forward:/handle01";
	}
	
	/**
	 * redirect:重定向到一个页面，或者控制器
	 * @return
	 */
	@RequestMapping("/handle03")
	public String handle03() {
		System.out.println("handle03");
		return "redirect:/handle02";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
