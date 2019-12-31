package com.cxz.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器步骤：
 * 	1）实现HandlerInterceptor接口
 *  2）SpringIOC容器中，注册这个拦截器
 *  		配置拦截范围（拦截哪些请求的目标方法）
 * @author 22527
 *
 */
public class FirstInterceptor implements HandlerInterceptor {

	/**
	 * 目标方法执行前运行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("FirstInterceptor………preHandle………");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("FirstInterceptor………postHandle………");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {	
		System.out.println("FirstInterceptor………afterCompletion………");
	}
}
