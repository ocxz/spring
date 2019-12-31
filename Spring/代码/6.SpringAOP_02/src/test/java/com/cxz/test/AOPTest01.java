package com.cxz.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cxz.impl.CalculatorImp;

@ContextConfiguration(locations="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AOPTest01 {

	@Autowired
//	Calcuator calcuator;
	CalculatorImp calcuator;
	
	@Test
	public void test() {
		calcuator.div(1, 0);
		System.out.println(calcuator.getClass());
	}
}
