package com.cxz.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxz.impl.CalculatorImp;

public class AOPTest01 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void test() {
		CalculatorImp calculatorImp = ioc.getBean("calculatorImp", CalculatorImp.class);
		calculatorImp.div(1, 0);
		System.out.println(calculatorImp.getClass());
	}
}
