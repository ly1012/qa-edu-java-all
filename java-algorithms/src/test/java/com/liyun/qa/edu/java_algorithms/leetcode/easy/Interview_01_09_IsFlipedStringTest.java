package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Interview_01_09_IsFlipedStringTest {

  @Test(description = "字符串轮转判断", dataProvider = "testIsFlipedString")
  public void testIsFlipedString(String s1, String s2, boolean expected) {
    boolean actual = Interview_01_09_IsFlipedString.isFlipedString(s1, s2);
    assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "testIsFlipedString")
  public Object[][] dataprovider(){
    return new Object[][]{
        {"aa", "aba", false},
        {"waterbottle", "erbottlewat", true},
        {"abcd", "abcd", true},
        {"abcd", "abcp", false}
    };
  }
}