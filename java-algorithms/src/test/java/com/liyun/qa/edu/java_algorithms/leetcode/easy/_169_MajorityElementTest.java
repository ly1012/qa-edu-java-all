package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class _169_MajorityElementTest {

  _169_MajorityElement aut = new _169_MajorityElement();


  @Test(dataProvider = "testcase")
  public void testByBoyer_MooreMajorityVoteAlgorithm(int[] nums,int expected) {
    assertEquals(aut.majorityElement(nums), expected);
  }

  @DataProvider(name = "testcase")
  public Object[][] testcase(){
    return new Object[][]{
        {new int[]{1,2,2}, 2},
        {new int[]{2,1,2}, 2},
        {new int[]{2,2,1}, 2},
        {new int[]{1,2,3,3,3}, 3},
        {new int[]{3,3,3,4,5}, 3},
        {new int[]{1,3,2,3,3}, 3},
        {new int[]{3,1,3,2,3}, 3},
        {new int[]{2,2,1,1,1,2,2}, 2},
        {new int[]{1,2,5,9,5,9,5,5,5}, 5}
    };
  }

}