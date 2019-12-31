package com.cxz.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试自定义视图解析器和视图对象
 * 
 * @author 22527
 *
 */
@Controller
public class MyViewResovlerController {

	@RequestMapping("/handlepus")
	public String handleplus(Model model) {

		List<String> vname = new ArrayList<String>(Arrays.asList("佟老师", "苍老师"));
		List<String> iname = new ArrayList<String>(Arrays.asList("萌萌", "大长腿"));
		model.addAttribute("video", vname);
		model.addAttribute("imgs", iname);
		return "meinv:/login";
	}
}
