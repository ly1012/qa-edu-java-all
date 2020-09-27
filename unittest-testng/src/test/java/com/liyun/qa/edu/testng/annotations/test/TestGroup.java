package com.liyun.qa.edu.testng.annotations.test;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Test 注解 group 属性测试
 */
public class TestGroup {


	@Test(groups = { "functest" })  
	public void testMethod3() { 
		System.err.println("groups = { functest }");
	}  
	
	@Test(groups = { "functest", "checkintest" })  
	public void testMethod1() {  
		System.err.println("groups = { functest, checkintest }");  
	}  

	@Test(groups = { "functest", "checkintest" })  
	public void testMethod2() {  
	    System.err.println("groups = { functest, checkintest }");  
	}  
	
	@Test(groups = { "checkintest" })  
	public void testMethod4() {  
	    System.err.println("groups = { checkintest }");  
	}
	
}
