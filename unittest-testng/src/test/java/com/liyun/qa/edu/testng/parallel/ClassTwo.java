package com.liyun.qa.edu.testng.parallel;

import org.testng.annotations.Test;

/**
 *
 * @author Li Yun
 * @date 2020/4/23 16:41
 */
public class ClassTwo {

  @Test
  public void test1() throws InterruptedException {
    System.out.println("Class2 test1");
    Thread.sleep(3000);
  }

}
