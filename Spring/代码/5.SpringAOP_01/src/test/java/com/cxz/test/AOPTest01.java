package com.cxz.test;

import java.util.Arrays;

import org.junit.Test;

import com.cxz.imp.CalculatorImp;
import com.cxz.inter.Calculator;
import com.cxz.proxy.CalculatorProxy;

public class AOPTest01 {

	/**
	 * 测试普通日志添加
	 */
	@Test
	public void test() {
		
		Calculator calculator = new CalculatorImp();
		
		calculator.add(1, 2);
		calculator.sub(1, 2);
	}
	
	/**
	 * 测试使用代理对象，添加日志
	 */
	@Test
	public void test2() {
		
		// 使用代理对象，创建计算器对象
		Calculator calculator = new CalculatorImp();
		Calculator proxy = CalculatorProxy.getProxy(calculator);
		System.out.println(proxy.getClass());
		System.out.println(Arrays.asList(proxy.getClass().getInterfaces()));
		proxy.add(1, 2);
		proxy.div(1, 0);
	}
}
