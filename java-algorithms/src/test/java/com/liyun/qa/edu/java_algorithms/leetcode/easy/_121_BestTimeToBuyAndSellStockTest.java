package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _121_BestTimeToBuyAndSellStockTest {

  _121_BestTimeToBuyAndSellStock aut = new _121_BestTimeToBuyAndSellStock();

  @Test(dataProvider = "dp2")
  public void testMaxProfit(int[] input, int expected) {
    int actual = aut.maxProfit(input);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test(dataProvider = "dp2")
  public void testMaxProfit2(int[] input, int expected) {
    int actual = aut.maxProfit2(input);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test(dataProvider = "dp2")
  public void testMaxProfit3(int[] input, int expected) {
    int actual = aut.maxProfit3(input);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "dp2")
  public Object[][] dp2(){
    return new Object[][]{
        {new int[]{}, 0},
        {new int[]{3}, 0},
        {new int[]{3, 5}, 2},
        {new int[]{7,1,5,3,6,4}, 5},
        {new int[]{7,6,4,3,1}, 0}
    };
  }
}