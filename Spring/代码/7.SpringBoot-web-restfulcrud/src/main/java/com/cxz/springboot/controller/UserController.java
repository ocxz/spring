package com.cxz.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@PostMapping("user/login")
	public String login(@RequestParam("username")String username, @RequestParam("password")String password,
			Model model, HttpSession session) {
		
		// 登陆成功
		if(!StringUtils.isEmpty(username) && "123456".equals(password)) {
			session.setAttribute("loginUser", username);
			return "redirect:/dashboard";
		} else {
			// 登陆失败
			model.addAttribute("msg", "用户名密码错误");
			return "login";
		}
	}
}
