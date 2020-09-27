package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class _26_RemoveDuplicatesFromSortedArrayTest {

  _26_RemoveDuplicatesFromSortedArray aut = new _26_RemoveDuplicatesFromSortedArray();

  @Test(dataProvider = "dp2")
  public void testRemoveDuplicates(int[] input, int[] expected1, int expected2) {
    int actual2= aut.removeDuplicates(input);
    Assertions.assertThat(actual2).isEqualTo(expected2);
    int[] actual1 = Arrays.copyOf(input, expected2);
    Assertions.assertThat(actual1).isEqualTo(expected1);
  }

  @DataProvider(name = "dp2")
  public Object[][] dp2(){
    return new Object[][]{
        {new int[]{}, new int[]{}, 0},
        {new int[]{10}, new int[]{10}, 1},
        {new int[]{1,1,2}, new int[]{1,2}, 2},
        {new int[]{0,0,1,1,1,2,2,3,3,4}, new int[]{0, 1, 2, 3, 4}, 5}
    };
  }
}