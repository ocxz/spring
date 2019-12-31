package com.cxz.view;

import java.util.Locale;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**
 * 自定义视图解析器
 * @author 22527
 *
 */
public class MyViewResolver implements ViewResolver, Ordered{

	private Integer order = 0;
	
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		
		// 根据视图名，返回视图对象
		if(viewName.startsWith("meinv:")) {
			return new MyView();
		} else {
			// 不能处理，返回null即可
			return null;
		}
	}
	
	/**
	 * 设置视图解析器的优先级
	 * @param order
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * 获得视图解析器的优先级
	 */
	@Override
	public int getOrder() {
		return this.order;
	}
}
