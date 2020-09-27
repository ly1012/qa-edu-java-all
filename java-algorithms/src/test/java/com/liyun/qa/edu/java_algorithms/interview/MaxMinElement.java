package com.liyun.qa.edu.java_algorithms.interview;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 问题1：求一个数组中最大最小的元素
 *
 * @author Li Yun
 * @date 2020/8/14 13:34
 */
public class MaxMinElement {

  public int[] maxMinElement(int[] arr){
    int max = arr[0];
    int min = arr[0];
    for (int i = 0; i < arr.length; i++) {
      max = arr[i] > max ? arr[i] : max;
      min = arr[i] < min ? arr[i] : min;
    }
    int[] result = new int[2];
    result[0] = max;
    result[1] = min;
    return result;
  }

  @Test(description = "数组最大最小元素测试",dataProvider = "dp_maxMinElement")
  public void testName(int[] input, int[] expected) {
    int[] actual =  maxMinElement(input);
    Assert.assertEquals(actual[0], expected[0]);
    Assert.assertEquals(actual[1], expected[1]);
  }

  @DataProvider(name = "dp_maxMinElement")
  public Object[][] dp_maxMinElement(){
    return new Object[][]{
        {new int[]{3, -9, 23, 7}, new int[]{23, -9}}
    };
  }

}
