package com.cxz.test;

import com.cxz.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext2.xml");

	/**
	 * 测试从容器中拿到Person组件
	 */
	@Test
	public void test() {
		// 根据当前引用xml的配置获取ioc容器
		// classPathxml标识xml文件在ClassPath中
		Person person = (Person) ioc.getBean("person01");
		System.out.println(person);
	}

	/**
	 * 实验2：根据bean的类型(class)从IOC容器中获取bean的实例★
	 */
	@Test
	public void test2() {
//		Person bean = ioc.getBean(Person.class);
		Person bean = ioc.getBean("person02", Person.class);
		System.out.println(bean);
	}

	/**
	 * 实验3：通过构造器为bean的属性赋值（index,type属性介绍）（带name属性，可无序测试）
	 */
	@Test
	public void test3() {
		Person bean = ioc.getBean("Person03", Person.class);
		System.out.println(bean);
	}
	
	/**
	 * 实验3：通过构造器为bean的属性赋值（index,type属性介绍）（顺序，不带name属性）
	 */
	@Test
	public void test3_2(){
		Person bean = ioc.getBean("Person04", Person.class);
		System.out.println(bean);
	}
	
	@Test
	public void test5() {
		Person bean = ioc.getBean("person05", Person.class);
		System.out.println(bean);
	}
	
	/**
	 * 实验4：正确的为各种属性赋值
	 */
	@Test
	public void test6() {
		Person bean = ioc.getBean("person01", Person.class);
		Car car = ioc.getBean(Car.class);
		System.out.println(bean.getCar());
		System.out.println(bean.getCar() == car);
		Person bean2 = ioc.getBean("person02", Person.class);
		System.out.println(bean2.getCar());
		
		Person bean3 = ioc.getBean("person03", Person.class);
		System.out.println(bean3.getBooks());
		
		Person bean4 = ioc.getBean("person04", Person.class);
		System.out.println(bean4.getMaps());
		
		Person bean5 = ioc.getBean("person05", Person.class);
		System.out.println(bean5.getProperties());
		
		Person bean6 = ioc.getBean("person06", Person.class);
		System.out.println(bean6.getCar());
		System.out.println(car);
	}
}
