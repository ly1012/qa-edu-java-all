package com.liyun.qa.edu.java_algorithms.interview;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 问题2：如何判断一个字符串中是否包含一个英文单词，例如 hello world ， 包含hello，但是不包含he。
 *
 * @author Li Yun
 * @date 2020/8/14 13:43
 */
public class EnglishWord {

  public boolean testWord(String input, String word){
    String[] words = input.split("[^a-zA-Z0-9]+");
    for (String w : words){
      if (w.equals(word)){
        return true;
      }
    }
    return false;
  }

  @Test(description = "判断一个字符串中是否包含一个英文单词测试",dataProvider = "dp_test")
  public void test(String input, String word, boolean expected) {
    boolean actual =  testWord(input, word);
    Assert.assertEquals(actual, expected);
  }

  @DataProvider(name = "dp_test")
  public Object[][] dp_test(){
    return new Object[][]{
        {"hello world", "hello", true},
        {"hello world", "he", false}
    };
  }

}
