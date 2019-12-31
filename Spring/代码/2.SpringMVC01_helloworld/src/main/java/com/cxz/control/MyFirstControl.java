package com.cxz.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cxz")
public class MyFirstControl {

	@RequestMapping(value = "/hello", method = RequestMethod.GET, params = { "userName=!123", "pwd!=123" })
	public String hander01() {
		return "success";
	}

	/**
	 * 使用header指定请求头 User-Agen
	 * 测试：指定不允许谷歌浏览器访问
	 * @return
	 */
	@RequestMapping(value = "/handel02", headers = {
			"User-Agent!=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.80 Safari/537.36"})
	public String hander02() {
		return "success";
	}
}
