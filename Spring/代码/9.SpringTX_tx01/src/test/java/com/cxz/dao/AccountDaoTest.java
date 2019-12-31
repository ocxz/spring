package com.cxz.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cxz.bean.Account;

@ContextConfiguration(locations="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountDaoTest {

	@Autowired
	AccountDao accountDao;
	
	@Test
	public void testUpdateBalance() {
		int updateBalance = accountDao.updateBalance("张三", 1);
		System.out.println("操作成功，影响行数：" + updateBalance);
	}
	
	@Test
	public void testSelectAllCount() {
		List<Account> allCount = accountDao.selectAllCount();
		for (Account account : allCount) {
			System.out.println(account);
		}
	}
	
	@Test
	public void testAddAccount() {
		accountDao.addAccount("王五", 10000);
	}
}
