package com.cxz.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试requestMapping的Ant风格的模糊匹配
 * @author 22527
 *
 */
@Controller
@RequestMapping("/ant")
public class RquestMappingAnt {

	
	/**
	 * 精确匹配
	 * @return
	 */
	@RequestMapping(value="/antTest01")
	public String  antTest01() {
		System.out.println("antTest01……");
		return "success";
	}
	
	/**
	 * 使用?代替任意字符
	 * @return
	 */
	@RequestMapping(value="/antTest0?")
	public String  antTest02() {
		System.out.println("antTest02……");
		return "success";
	}
	
	/**
	 * 使用*代替任意多个字符和一层路径
	 * @return
	 */
	@RequestMapping(value="/*/antTest0*")
	public String  antTest03() {
		System.out.println("antTest03……");
		return "success";
	}
	
	/**
	 * 使用**匹配任意层路径
	 * @return
	 */
	@RequestMapping(value="/**/antTest0*")
	public String  antTest04() {
		System.out.println("antTest04……");
		return "success";
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("user/{userName}")
	public String PathVariableTest(@PathVariable("userName")String userName) {
		System.out.println(userName);
		return "success";
	}
}
