package com.liyun.qa.edu.parallel;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * TODO
 *
 * @author Li Yun
 * @date 2020/4/23 16:41
 */
public class ClassOne {

  @BeforeTest
  @Parameters("browser")
  public void beforeTest(String browser){
    System.out.println(browser);
  }

  @Test
  public void test1(){
    System.out.println("Class1 test1");
  }


}
