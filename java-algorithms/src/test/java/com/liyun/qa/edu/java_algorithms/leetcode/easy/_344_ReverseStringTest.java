package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _344_ReverseStringTest {

  @Test(description = "反转字符串测试", dataProvider = "testcase_testReverseString")
  public void testReverseString(String actual, String expected) {
    assertThat(_344_ReverseString.reverse(actual)).isEqualTo(expected);
  }

  @Test(description = "原地反转字符数组测试，算法1", dataProvider = "testcase_testReverseCharArray")
  public void testReverseCharArray(char[] actual, char[] expected) {
    _344_ReverseString.reverse(actual);
    assertThat(actual).isEqualTo(expected);
  }

  @Test(description = "原地反转字符数组测试，算法2", dataProvider = "testcase_testReverseCharArray")
  public void testReverseCharArray2(char[] actual, char[] expected) {
    _344_ReverseString.reverse2(actual);
    assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "testcase_testReverseString")
  public Object[][] testcase_testReverseString(){
    return new Object[][]{
        {"", ""},                 //0 个字符
        {"a", "a"},               //1 个字符
        {"ab", "ba"},             //2 个字符
        {"abc", "cba"},           //奇数个字符
        {"abcde", "edcba"},       //偶数个字符
        {"a b&", "&b a"},         //包含特殊字符
        {"123", "321"},           //纯数字
        {"aaaa", "aaaa"},         //所有的字符相同
        {"a\nb\tc", "c\tb\na"}    //包含特殊字符
    };
  }

  @DataProvider(name = "testcase_testReverseCharArray")
  public Object[][] testcase_testReverseCharArray(){
    return new Object[][]{
        {new char[]{}, new char[]{}},                                       //0 个字符
        {new char[]{'a'}, new char[]{'a'}},                                 //1 个字符
        {new char[]{'a','b'}, new char[]{'b','a'}},                         //2 个字符
        {new char[]{'a','b','c'}, new char[]{'c','b','a'}},                 //奇数个字符
        {new char[]{'a','b','c','d','e'}, new char[]{'e','d','c','b','a'}}, //偶数个字符
        {new char[]{'a',' ','b','&'}, new char[]{'&','b',' ','a'}},         //包含特殊字符
        {new char[]{'1','2','3'}, new char[]{'3','2','1'}},                 //纯数字
        {new char[]{'a','a','a','a'}, new char[]{'a','a','a','a'}},         //所有的字符相同
        {new char[]{'a','\n','b','\t','c'}, new char[]{'c','\t','b','\n','a'}}    //包含特殊字符
    };
  }

}