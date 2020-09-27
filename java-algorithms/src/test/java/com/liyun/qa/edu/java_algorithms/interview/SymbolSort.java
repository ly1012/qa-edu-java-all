package com.liyun.qa.edu.java_algorithms.interview;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 问题3：编码实现：有一组符号['-', '-', '+', '+', '+','-', '+','-', '+','-','-']，要求将“+”排到左边，“-”排到右边
 *
 * @author Li Yun
 * @date 2020/8/14 13:51
 */
public class SymbolSort {

  /**
   * 计数排序
   * @param input 输入符号序列
   * @return 排序后的符号序列
   */
  public char[] sortSymbol(char[] input){
    int[] count = new int[2];
    for (char c : input){
      if (c == '+'){
        count[0]++;
      }else {
        count[1]++;
      }
    }

    char[] results = new char[input.length];
    int m = 0;
    for (int i =0; i < count[0]; i++){
      results[m] = '+';
      m++;
    }
    for (int i = 0; i < count[1]; i++){
      results[m] = '-';
      m++;
    }
    return results;
  }

  @Test(dataProvider = "dp_testSortSymbol")
  public void testSortSymbol(char[] input, char[] expected) {
    char[] actual = sortSymbol(input);
    Assert.assertEquals(actual, expected);
  }

  @DataProvider(name = "dp_testSortSymbol")
  public Object[][] dp_testSortSymbol(){
    return new Object[][]{
        {
          new char[]{'-', '-', '+', '+', '+','-', '+','-', '+','-','-'},
          new char[]{'+', '+', '+', '+', '+','-', '-','-', '-','-','-'}
        }
    };
  }

  @Test(description = "+ - ACSII 码顺序")
  public void testName() {
    System.out.println('+' < '-');
  }
}
