package com.cxz.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImp implements BeanPostProcessor {

	/**
	 * 前置方法：初始化前调用
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization：【"+beanName+"】的bean将要初始化了，此bean：" + bean);
		return bean;
	}

	/**
	 * 后置方法
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization：【"+beanName+"】的bean初始化完成，此bean：" + bean);
		return bean;
	}
}
