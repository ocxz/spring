package com.cxz.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cxz.dao.BaseDao;

public class BaseService<T>{

	
	/**
	 * 加的不是baseDao，而是根据泛型类型，装配相应的Dao
	 * 所以：BaseDao不需要注册到容器中
	 */
	@Autowired
	BaseDao<T> baseDao;
	
	public void save() {
		System.out.println("自动注入的dao：" + baseDao);
		baseDao.save();
	}
}
