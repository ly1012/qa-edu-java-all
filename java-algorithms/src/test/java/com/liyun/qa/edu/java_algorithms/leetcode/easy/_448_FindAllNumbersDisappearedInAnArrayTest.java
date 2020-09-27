package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _448_FindAllNumbersDisappearedInAnArrayTest {

  _448_FindAllNumbersDisappearedInAnArray aut = new _448_FindAllNumbersDisappearedInAnArray();

  @Test(dataProvider = "dp3")
  public void testFindDisappearedNumbers(int[] input, int[] expected) {
    Integer[] actual = aut.findDisappearedNumbers(input).toArray(new Integer[0]);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test(dataProvider = "dp3")
  public void testFindDisappearedNumbers2(int[] input, int[] expected) {
    Integer[] actual = aut.findDisappearedNumbers2(input).toArray(new Integer[0]);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "dp3")
  public Object[][] dp3(){
    return new Object[][]{
        {new int[]{1}, new int[]{}},
        {new int[]{2,1}, new int[]{}},
        {new int[]{3,1,1}, new int[]{2}},
        {new int[]{4,3,2,7,8,2,3,1}, new int[]{5, 6}}
    };
  }

}