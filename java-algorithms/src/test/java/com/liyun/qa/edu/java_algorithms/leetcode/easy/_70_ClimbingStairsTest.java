package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _70_ClimbingStairsTest {

  _70_ClimbingStairs aut = new _70_ClimbingStairs();

  @Test(description = "递归解法", dataProvider = "dp")
  public void testClimbStairs(int n, int expected) {
    int actual = aut.climbStairs(n);
    assertThat(actual).isEqualTo(expected);
  }

  @Test(description = "动态规划解法", dataProvider = "dp")
  public void testClimbStairs2(int n, int expected) {
    int actual = aut.climbStairs2(n);
    assertThat(actual).isEqualTo(expected);
  }

  @Test(description = "动态规划解法：精简代码", dataProvider = "dp")
  public void testClimbStairs3(int n, int expected) {
    int actual = aut.climbStairs3(n);
    assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "dp")
  public Object[][] dp(){
    return new Object[][]{
        {1, 1},
        {2, 2},
        {3, 3},
        {4, 5},
        {5, 8},
        {20, 10946},
        {40, 165580141},
        {45, 1836311903}
    };
  }
}