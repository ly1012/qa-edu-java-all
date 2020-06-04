package com.liyun.qa.edu.listener;

import org.testng.annotations.*;

/**
 * 监听器测试
 *
 * @author Li Yun
 * @date 2020/5/12 16:36
 */
public class ListenerTest2 {

  static {
    System.out.println(Thread.currentThread().getStackTrace()[1] + "测试类实例化：静态代码块");
  }

  {
    System.out.println(Thread.currentThread().getStackTrace()[1] + "测试类实例化：非静态代码块");
  }

  public ListenerTest2() {
    System.out.println(Thread.currentThread().getStackTrace()[1] + "测试类实例化：无参构造器");
  }

  @BeforeClass
  public void beforeClass() {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }

  @BeforeMethod
  public void beforeMethod() {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }

  @Test
  public void testSomething() {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }

  @Test
  public void testException() {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
    assert false;
  }

  @AfterMethod
  public void afterMethod() {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }

  @AfterClass
  public void afterClass() {
    System.out.println(Thread.currentThread().getStackTrace()[1]);
  }
}
