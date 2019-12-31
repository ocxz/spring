package com.cxz.dao;

import org.springframework.stereotype.Repository;

import com.cxz.bean.User;

@Repository
public class UserDao extends BaseDao<User>{

	@Override
	public void save() {
		System.out.println("UserDao-->保存用户");
	}
}
