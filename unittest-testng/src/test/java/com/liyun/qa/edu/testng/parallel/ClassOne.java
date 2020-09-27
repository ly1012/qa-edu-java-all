package com.liyun.qa.edu.testng.parallel;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author Li Yun
 * @date 2020/4/23 16:41
 */
public class ClassOne {

  @BeforeTest
  @Parameters("com.liyun.qa.edu.appium.browser")
  public void beforeTest(String browser){
    System.out.println(browser);
  }

  @Test
  public void test1(){
    System.out.println("Class1 test1");
  }


}
