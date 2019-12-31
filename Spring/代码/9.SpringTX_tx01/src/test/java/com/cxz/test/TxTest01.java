package com.cxz.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cxz.dao.AccountDao;

@ContextConfiguration(locations="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TxTest01 {

	@Autowired
	DataSource datasource;
	@Autowired
	AccountDao accountDao;
	
	/**
	 * 测试数据源
	 * @throws SQLException 
	 */
	@Test
	public void test01() throws SQLException {
//		accountDao.up
//		System.out.println(datasource.getConnection());
	}
	
	
}
