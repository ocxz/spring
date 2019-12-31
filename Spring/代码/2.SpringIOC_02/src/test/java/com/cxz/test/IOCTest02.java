package com.cxz.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxz.bean.Car;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class IOCTest02 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext2.xml");

	/**
	 * 测试获取连接池
	 * 
	 * @throws SQLException
	 */
	@Test
	public void test01() throws SQLException {

		DataSource dataSource1 = ioc.getBean("dataSource1", ComboPooledDataSource.class);
		DataSource dataSource2 = ioc.getBean("dataSource2", ComboPooledDataSource.class);
		System.out.println(dataSource1.getConnection());
		System.out.println(dataSource2.getConnection());
	}
	
	/**
	 * 测试${username}到底是什么
	 */
	@Test
	public void test02() {
		Car car = ioc.getBean("carTest", Car.class);
		System.out.println(car);
	}	
}
