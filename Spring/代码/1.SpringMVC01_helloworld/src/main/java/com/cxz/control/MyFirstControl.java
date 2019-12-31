package com.cxz.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFirstControl {

	@RequestMapping("hello")
	public String myFirstRequest() {
		System.out.println("请求收到了……正在处理");
		// 视图解析器：根据配置的前后缀，自动拼接url
		// 前缀：/WEB-INF/pages
		// 后缀：.jsp
		// 返回：/WEB-INF/pages/success.jsp
		return "success";
	}
}
