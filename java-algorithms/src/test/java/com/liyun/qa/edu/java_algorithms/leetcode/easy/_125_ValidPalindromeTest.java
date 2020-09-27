package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _125_ValidPalindromeTest {

  _125_ValidPalindrome aut = new _125_ValidPalindrome();

  @Test(dataProvider = "dp4")
  public void testIsPalindrome(String input, boolean expected) {
    boolean actual = aut.isPalindrome(input);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "dp4")
  public Object[][] dp4(){
    return new Object[][]{
        {"     ", true},
        {"race a car", false},
        {"A man, a plan, a canal: Panama", true},
        {"   a,._=b**a", true},
        {"   a,._=b**c-a", false},
        {"aba", true},
        {"0P", false}
    };
  }
}