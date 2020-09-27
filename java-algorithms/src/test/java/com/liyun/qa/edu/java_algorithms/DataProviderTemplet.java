package com.liyun.qa.edu.java_algorithms;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * DataProvider 模板
 *
 * @author Li Yun
 * @date 2020/8/17 14:44
 */
public class DataProviderTemplet {

  public void test(){
    //int actual = aut.maxProfit(input);
    //Assertions.assertThat(actual).isEqualTo(expected);
  }

  // 参数：
  // int input, int expected
  @DataProvider(name = "dp1")
  public Object[][] dp1(){
    return new Object[][]{
        {123, 321},
        {-123, -321}
    };
  }

  // 参数：
  // int[] input, int expected
  @DataProvider(name = "dp2")
  public Object[][] dp2(){
    return new Object[][]{
        {new int[]{1,2,3,1}, 4},
        {new int[]{2,7,9,3,1}, 12}
    };
  }

  // 参数：
  // int[] input, int[] expected
  @DataProvider(name = "dp3")
  public Object[][] dp3(){
    return new Object[][]{
        {new int[]{0}, new int[]{0}},
        {new int[]{1}, new int[]{1}},
        {new int[]{0,1}, new int[]{1,0}},
        {new int[]{2,1}, new int[]{2,1}},
        {new int[]{0,0,0}, new int[]{0,0,0}},
        {new int[]{0,1,0,3,12}, new int[]{1,3,12,0,0}}
    };
  }

  // 参数：
  // String input, int expected
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

  @Test
  public void testName() {
    System.out.println((int)'a');
    System.out.println((int)'z');
    System.out.println((int)'A');
    System.out.println((int)'Z');
    System.out.println((int)'0');
    System.out.println((int)'9');

  }
}
