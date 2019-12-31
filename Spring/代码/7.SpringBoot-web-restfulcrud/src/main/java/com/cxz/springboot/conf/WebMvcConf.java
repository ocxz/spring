package com.cxz.springboot.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cxz.springboot.resolver.MyLocaleResolver;

/**
 * 实现WebMvcConfigurer接口，扩展SpringMVC的功能 需要扩展什么功能，就重写实现WebMvcConfigurer中的哪个方法
 * 
 * @author 22527
 *
 */
@Configuration
public class WebMvcConf implements WebMvcConfigurer {

	// 定义拦截器排除的路径
	final String[] excludePath = { "/index.html", "/", "/index", "/user/login", "/webjars/**", "/asserts/**" };

	/**
	 * 自定义视图空
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/index.html").setViewName("login");
		registry.addViewController("/index").setViewName("login");
		registry.addViewController("/dashboard").setViewName("dashboard");
	}

	/**
	 * 注册拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePath);
	}

	/**
	 * 注册自定义区域信息解析器
	 * 
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}
}
