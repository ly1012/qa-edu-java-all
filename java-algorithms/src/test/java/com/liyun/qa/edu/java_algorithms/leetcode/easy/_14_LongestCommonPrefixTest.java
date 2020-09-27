package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _14_LongestCommonPrefixTest {

  _14_LongestCommonPrefix aut = new _14_LongestCommonPrefix();

  @Test(dataProvider = "dp5")
  public void testLongestCommonPrefix(String[] input, String expected) {
    String actual = aut.longestCommonPrefix(input);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "dp5")
  public Object[][] dp5(){
    return new Object[][]{
        {new String[]{"flower","flow","flight"}, "fl"},
        {new String[]{"dog","racecar","car"}, ""}
    };
  }


}