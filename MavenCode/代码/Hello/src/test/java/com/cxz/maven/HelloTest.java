package com.cxz.maven;
import org.junit.Test;
import static junit.framework.Assert.*;
public class HelloTest{
	@Test
	public void testHello(){
		Hello hello = new Hello();
		String results = hello.sayHello("cxz");
		assertEquals("Hello cxz!", results);
	}
}