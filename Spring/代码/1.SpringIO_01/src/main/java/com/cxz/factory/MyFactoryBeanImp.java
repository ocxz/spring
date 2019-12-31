package com.cxz.factory;

import java.util.UUID;

import org.springframework.beans.factory.FactoryBean;

import com.cxz.bean.Book;

/**
 * 实现spring定义的工厂接口类 Spring会自动调用工厂方法，创建实例
 * 
 * @author 22527
 *
 */
public class MyFactoryBeanImp implements FactoryBean<Book> {

	/**
	 * 工厂方法，返回创建对象
	 */
	@Override
	public Book getObject() throws Exception {
		Book book = new Book();
		book.setBookName(UUID.randomUUID().toString());
		System.out.println("MyFactoryBean帮你创建对象");
		return book;
	}

	/**
	 * 返回创建对象的类型
	 */
	@Override
	public Class<?> getObjectType() {
		return Book.class;
	}

	/**
	 * 返回创建对象是单例吗？
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}
}
