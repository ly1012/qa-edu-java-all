package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-integer/">7. 整数反转</a>
 *
 * @author Li Yun
 * @date 2020/8/15 11:11
 */
public class _7_ReverseIntegerTest {

  _7_ReverseInteger aut = new _7_ReverseInteger();

  @Test(dataProvider = "dp")
  public void testcase(int input, int expected) {
    Assertions.assertThat(aut.reverse(input)).isEqualTo(expected);
    Assertions.assertThat(aut.reverse2(input)).isEqualTo(expected);
  }

  @DataProvider(name = "dp")
  public Object[][] dp(){
    return new Object[][]{
        {123, 321},
        {-123, -321},
        {120, 21},
        {2147483647, 0}
    };
  }

  @Test
  public void testName() {
    System.out.println(-32 / 10);
  }
}
