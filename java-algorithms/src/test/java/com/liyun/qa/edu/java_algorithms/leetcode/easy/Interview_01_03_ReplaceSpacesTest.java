package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Interview_01_03_ReplaceSpacesTest {

  @Test(description = "URL化，算法1：使用 Java API", dataProvider = "testcase")
  public void testReplaceSpaces(String input, int length, String expected) {
    String actual = Interview_01_03_ReplaceSpaces.replaceSpaces(input, length);
    assertThat(actual).isEqualTo(expected);
  }

  @Test(description = "URL化，算法2：使用额外的新数组", dataProvider = "testcase")
  public void testReplaceSpaces2(String input, int length, String expected) {
    String actual = Interview_01_03_ReplaceSpaces.replaceSpaces2(input, length);
    assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "testcase")
  public Object[][] testcase(){
    return new Object[][]{
        {"Mr John Smith    ", 13, "Mr%20John%20Smith"},   //真实长度小于完整长度
        {"               ", 5, "%20%20%20%20%20"},        //全部是空格
        {"aacc", 4, "aacc"},                              //没有空格
        {"  a  ", 5, "%20%20a%20%20"},                    //开头结尾是空格
        {"", 0, ""}                                          //空字符串
    };
  }
}