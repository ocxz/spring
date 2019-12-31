package com.cxz.springboot.resolver;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

/**
 * 可以在超链接上，获取区域信息
 * @author 22527
 *
 */
public class MyLocaleResolver implements LocaleResolver{

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String el = request.getParameter("el");
		if(!StringUtils.isEmpty(el)) {
			String[] els = el.split("_");
			return new Locale(els[0], els[1]);
		}
		// 没有带，使用操作系统的
		return Locale.getDefault();
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		// TODO Auto-generated method stub
		
	}	
}
