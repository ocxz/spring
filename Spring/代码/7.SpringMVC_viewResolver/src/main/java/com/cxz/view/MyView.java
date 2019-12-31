package com.cxz.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

/**
 * 自定义视图
 * 
 * @author 22527
 *
 */
public class MyView implements View {

	/**
	 * 返回数据的数据类型
	 */
	@Override
	public String getContentType() {
		return "text/html";
	}

	/**
	 * model就是之前Model、Map存放数据的对象
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("之前保存的数据" + model);
		// 设置内容类型
		response.setContentType("text/html");
		response.getWriter().write("哈哈，<h1>即将展现精彩内容……</h1>");

		for (String v : (List<String>) model.get("video")) {
			response.getWriter().write("<a>下载" + v + ".avi</a><br/>");
		}
		for (String i : (List<String>) model.get("imgs")) {
			response.getWriter().write("<a>下载" + i + ".jpg</a><br/>");
		}
		
		response.getWriter().write("<script type=\"text/javascript\">"
				+ "var aEles = document.getElementsByTagName('a');"
				+ "aEles.onclick=function(){"
				+ "alert('想要下载吗？交钱');"
				+ "}"
				+ "</script>");
		
	}
}
