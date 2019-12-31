package com.cxz.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes(value = { "msg"}, types= {String.class})
@Controller
public class OutputController {

	@RequestMapping(value = "/handle01")
	public String handle01(Map<String, Object> map) {
		map.put("msg", "你好");
		map.put("content", "中国");
		return "success";
	}

	@RequestMapping(value = "/handle02")
	public String handle02(Model model) {
		model.addAttribute("msg", "你好，中国");
		return "success";
	}

	@RequestMapping(value = "/handle03")
	public String handle03(ModelMap modelMap) {
		modelMap.addAttribute("msg", "你好鸭，中国");
		System.out.println(modelMap.getClass());
		return "success";
	}

	@RequestMapping(value = "/handle04")
	public ModelAndView handle04() {
		// 之前的返回值就是视图名，由视图解析器帮我们进行URL拼接
		ModelAndView view = new ModelAndView("success");
		view.addObject("msg", "你好，中国鸭");
		return view;
	}

	@RequestMapping(value="/handle05")
	public String handle05(Model model) {
		model.addAttribute("msg", 189);
		// 通过类型匹配，添加到session中
		model.addAttribute("msg1", "你好，中国");
		return "success";
	}
}
