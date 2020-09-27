package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Interview_01_02_CheckPermutationTest {

  @Test(description = "互为字符重排，算法1：字符数组排序，比较相同位置字符是否一样", dataProvider = "testcase")
  public void testCheckPermutation(String s1, String s2, boolean expected) {
    boolean actual = Interview_01_02_CheckPermutation.checkPermutation(s1, s2);
    assertThat(actual).isEqualTo(expected);
  }

  @Test(description = "互为字符重排，算法2：散列表，HashMap 统计字符出现次数", dataProvider = "testcase")
  public void testCheckPermutation2(String s1, String s2, boolean expected) {
    boolean actual = Interview_01_02_CheckPermutation.checkPermutation2(s1, s2);
    assertThat(actual).isEqualTo(expected);
  }

  @Test(description = "互为字符重排，算法3：散列表，HashMap 统计字符出现次数", dataProvider = "testcase")
  public void testCheckPermutation3(String s1, String s2, boolean expected) {
    boolean actual = Interview_01_02_CheckPermutation.checkPermutation3(s1, s2);
    assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "testcase")
  public Object[][] testcase(){
    return new Object[][]{
        {"abc", "bca", true},                       //互为字符重排
        {"abc", "bad", false},                      //存在不相同的字符
        {"", "", true},                             //空字符串
        {"a", "a", true},                           //一个字符
        {"我们我", "我我们", true},                  //中文字符
        {"aaaa", "aaaa", true}                      //互为字符重排
    };
  }

}