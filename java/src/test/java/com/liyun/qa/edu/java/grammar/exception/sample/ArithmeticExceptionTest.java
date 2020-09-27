package com.liyun.qa.edu.java.grammar.exception.sample;

import org.testng.annotations.Test;

/**
 * {@link java.lang.ArithmeticException} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 11:43
 */
public class ArithmeticExceptionTest {

  @Test(description = "java.lang.ArithmeticException: / by zero")
  public void testArithmeticException() {
    System.out.println(5/0);
  }

}
