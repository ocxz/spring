package com.cxz.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxz.bean.AirPlane;
import com.cxz.bean.Book;
import com.cxz.factory.MyFactoryBeanImp;

public class IOCTest03 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext4.xml");
	@Test
	public void test() {
		System.out.println("容器启动完成");
	}
	
	@Test
	public void test02() {
		AirPlane plane1 = ioc.getBean("plane01", AirPlane.class);
		AirPlane plane2 = ioc.getBean("plane02", AirPlane.class);
		System.out.println(plane1);
		System.out.println(plane2);
	}
	
	/**
	 * 测试从FactoryBean中获取bean
	 */
	@Test
	public void test03() {
		Object bean = ioc.getBean("myFactoryBean", Book.class);
		System.out.println(bean);
	}
}
