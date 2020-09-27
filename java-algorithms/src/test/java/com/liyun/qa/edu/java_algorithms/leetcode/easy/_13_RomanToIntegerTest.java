package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _13_RomanToIntegerTest {

  _13_RomanToInteger aut = new _13_RomanToInteger();

  @Test(dataProvider = "dp4")
  public void testRomanToInt(String input, int expected) {
    int actual = aut.romanToInt(input);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test(dataProvider = "dp4")
  public void testRomanToInt2(String input, int expected) {
    int actual = aut.romanToInt2(input);
    Assertions.assertThat(actual).isEqualTo(expected);
  }

  @Test(dataProvider = "dp4")
  public void testRomanToInt3(String input, int expected) {
    int actual = aut.romanToInt3(input);
    Assertions.assertThat(actual).isEqualTo(expected);
  }


  @DataProvider(name = "dp4")
  public Object[][] dp4(){
    return new Object[][]{
        {"III", 3},
        {"IV", 4},
        {"IX", 9},
        {"LVIII", 58},
        {"MCMXCIV", 1994}
    };
  }

}