package com.cxz.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxz.util.Utils;

@Controller
public class I18nTestController {

	@Autowired
	ResourceBundleMessageSource messageSource;
	@Autowired
	Utils utils;
	
	@RequestMapping("toLoginPage")
	public String toLoginPage(HttpSession session, HttpServletRequest request) {
		session.setAttribute("ctp", request.getContextPath());
//		utils.setLocale(request, "locale");
		return "login";
	}
	// http://localhost:8080/SpringMVC_i18n/index
	// http://localhost:8080/SpringMVC_i18n/
	
	@RequestMapping("index")
	public String toIndex(HttpSession session, HttpServletRequest request, Locale locale) {
		session.setAttribute("ctp", request.getContextPath());
		System.out.println(locale);
		System.out.println(messageSource.getMessage("tologinPage", null, locale));
		return "index";
	}
}
