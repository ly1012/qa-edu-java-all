package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _198_HouseRobberTest {

  _198_HouseRobber aut = new _198_HouseRobber();

  @Test(dataProvider = "dp")
  public void testRob(int[] input, int expected) {
    int actual = aut.rob(input);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "dp")
  public Object[][] dp(){
    return new Object[][]{
        {new int[]{1,2,3,1}, 4},
        {new int[]{2,7,9,3,1}, 12},
        {new int[]{2,7,9,3,1,23,4,9,2,8,24,98,21,1,2,9,88,52}, 239},
    };
  }
}