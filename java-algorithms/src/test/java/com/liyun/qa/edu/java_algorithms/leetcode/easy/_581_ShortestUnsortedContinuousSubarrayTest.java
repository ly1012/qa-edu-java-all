package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _581_ShortestUnsortedContinuousSubarrayTest {

  _581_ShortestUnsortedContinuousSubarray aut = new _581_ShortestUnsortedContinuousSubarray();

  @Test(dataProvider = "dp2")
  public void testFindUnsortedSubarray(int[] input, int expected) {
    int actual = aut.findUnsortedSubarray(input);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test(dataProvider = "dp2")
  public void testFindUnsortedSubarray2(int[] input, int expected) {
    int actual = aut.findUnsortedSubarray2(input);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test(dataProvider = "dp2")
  public void testFindUnsortedSubarray3(int[] input, int expected) {
    int actual = aut.findUnsortedSubarray3(input);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test(dataProvider = "dp2")
  public void testFindUnsortedSubarray4(int[] input, int expected) {
    int actual = aut.findUnsortedSubarray4(input);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test(dataProvider = "dp2")
  public void testFindUnsortedSubarray5(int[] input, int expected) {
    int actual = aut.findUnsortedSubarray5(input);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "dp2")
  public Object[][] dp2(){
    return new Object[][]{
        {new int[]{1}, 0},
        {new int[]{1,3}, 0},
        {new int[]{3,1}, 2},
        {new int[]{2, 6, 4, 8, 10, 9, 15}, 5},
        {new int[]{1, 4, 6, 10, 5, 12, 15}, 3}
    };
  }
}