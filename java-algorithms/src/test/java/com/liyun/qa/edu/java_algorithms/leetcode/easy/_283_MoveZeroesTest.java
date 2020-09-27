package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _283_MoveZeroesTest {

  _283_MoveZeroes aut = new _283_MoveZeroes();

  @Test(dataProvider = "dp3")
  public void testMoveZeroes(int[] input, int[] expected) {
    aut.moveZeroes(input);
    Assertions.assertThat(input).isEqualTo(expected);
  }

  @DataProvider(name = "dp3")
  public Object[][] dp3(){
    return new Object[][]{
        {new int[]{0}, new int[]{0}},
        {new int[]{1}, new int[]{1}},
        {new int[]{0,1}, new int[]{1,0}},
        {new int[]{2,1}, new int[]{2,1}},
        {new int[]{0,0,0}, new int[]{0,0,0}},
        {new int[]{0,1,0,3,12}, new int[]{1,3,12,0,0}}
    };
  }
}