package com.liyun.qa.edu.java.grammar.exception.sample;

import org.testng.annotations.Test;

/**
 * {@link java.lang.AssertionError} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 15:02
 */
public class AssertionErrorTest {

  @Test(description = "java.lang.AssertionError: 计算 1 + 1，预期值：3，实际值 2 ")
  public void testAssertionError() {
    assert 1 + 1 == 3 : "计算 1 + 1，预期值：3，实际值 2 ";
  }

}
