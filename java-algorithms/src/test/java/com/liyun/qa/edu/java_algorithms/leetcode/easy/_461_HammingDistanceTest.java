package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _461_HammingDistanceTest {

  _461_HammingDistance aut = new _461_HammingDistance();

  @Test(dataProvider = "dp1")
  public void testHammingDistance(int x, int y, int expected) {
    int actual = aut.hammingDistance(x, y);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test(dataProvider = "dp1")
  public void testHammingDistance2(int x, int y, int expected) {
    int actual = aut.hammingDistance2(x, y);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "dp1")
  public Object[][] dp1(){
    return new Object[][]{
        {0, 0, 0},
        {5423, 5423, 0},
        {1, 4, 2},
        {123823, 423523, 11}
    };
  }
}