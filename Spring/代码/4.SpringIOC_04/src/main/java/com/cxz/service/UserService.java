package com.cxz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxz.bean.User;
import com.cxz.dao.UserDao;

@Service
public class UserService  extends BaseService<User>{

//	@Autowired
//	UserDao userDao;
//
//	public void save() {
//		userDao.save();
//	}
}
