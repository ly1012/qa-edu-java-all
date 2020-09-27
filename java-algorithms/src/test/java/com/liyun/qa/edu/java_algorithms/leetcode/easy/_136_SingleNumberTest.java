package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _136_SingleNumberTest {

  _136_SingleNumber aut = new _136_SingleNumber();

  @Test(dataProvider = "dp")
  public void testSingleNumber(int[] input, int expected) {
    assertThat(aut.singleNumber(input)).isEqualTo(expected);
  }

  @DataProvider(name = "dp")
  public Object[][] dp(){
    return new Object[][]{
        {new int[]{2}, 2},
        {new int[]{2,2,1}, 1},
        {new int[]{4,1,2,1,2}, 4}
    };
  }
}