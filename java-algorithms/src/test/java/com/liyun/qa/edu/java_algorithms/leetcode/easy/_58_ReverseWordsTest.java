package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _58_ReverseWordsTest {

  @Test(description = "翻转单词顺序，算法1：数组反转", dataProvider = "testReverseWords")
  public void testReverseWords(String input, String expected) {
    String actual = _58_ReverseWords.reverseWords(input);
    assertThat(actual).isEqualTo(expected);
  }

  @Test(description = "翻转单词顺序，算法2：逆序追加", dataProvider = "testReverseWords")
  public void testReverseWords2(String input, String expected) {
    String actual = _58_ReverseWords.reverseWords2(input);
    assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "testReverseWords")
  public Object[][] dataprovider(){
    return new Object[][]{
        {"the sky is blue", "blue is sky the"},
        {"  hello world!  ", "world! hello"},
        {"a good   example", "example good a"}
    };
  }

}