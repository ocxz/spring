package com.cxz.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class PropertiesFileHandleTest {

	String filePath = "F:\\JAVA\\Spring\\9.SpringMVC_dataBinder\\conf\\valid-weight.properties";
	PropertiesFileHandle pfh = new PropertiesFileHandle(filePath);
	
	@Test
	public void testGetProp() {
		System.out.println(pfh + "测试testGetProp");
	}

	@Test
	public void testGetValue() {
		System.out.println(pfh.getValue("NotNull"));
	}

	@Test
	public void testGetIntValue() {
		System.out.println(pfh.getIntValue("NotNullff"));
	}

	@Test
	public void testGetBoolValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDoubleValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValues() {
		System.out.println(pfh.getValues("NotNull","Null"));
	}
}
