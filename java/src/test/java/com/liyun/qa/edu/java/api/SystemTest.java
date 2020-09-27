package com.liyun.qa.edu.java.api;

import org.testng.annotations.Test;

/**
 * {@link System} 类测试
 *
 * @author Li Yun
 * @date 2020/8/3 21:19
 */
public class SystemTest {

  @Test(description = "格式化打印")
  public void testPrintf() {
    System.out.printf("a\n%s\nb\n%s", "A", "B");
  }

}
