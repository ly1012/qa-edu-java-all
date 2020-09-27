package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _58_ReverseLeftWordsTest {

  @Test(description = "左旋转字符串，算法1：直接使用 substring 方法", dataProvider = "testReverseLeftWords")
  public void testReverseLeftWords(String input, int len, String expected) {
    String actual = _58_ReverseLeftWords.reverseLeftWords(input, len);
    assertThat(actual).isEqualTo(expected);
  }

  @Test(description = "左旋转字符串，算法2：使用临时数组存储左旋转字符序列", dataProvider = "testReverseLeftWords")
  public void testReverseLeftWords2(String input, int len, String expected) {
    String actual = _58_ReverseLeftWords.reverseLeftWords2(input, len);
    assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "testReverseLeftWords")
  public Object[][] dataprovider(){
    return new Object[][]{
        {"abcd", 0, "abcd"},
        {"a", 0, "a"},
        {"abcdefg", 2, "cdefgab"},
        {"lrloseumgh", 6, "umghlrlose"}
    };
  }
}