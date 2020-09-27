package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import org.testng.annotations.Test;

/**
 * 阿里在线测试，问题5：给定一个整数数组，例如 -5 2 6 8 -20 -10 5 -10 20 -5 -6，求连续整数之最大和
 * 原题为 <a href="https://leetcode-cn.com/problems/maximum-subarray/">53. 最大子序和</a>
 *
 * @author Li Yun
 * @date 2020/8/14 14:10
 */
public class _53_MaximumSubarrayTest {

  _53_MaximumSubarray aut = new _53_MaximumSubarray();

  @Test
  public void testSum() {
    int[] arr = new int[]{-5,2,6,8,-20,-10,5,-10,20,-5,-6};
    System.out.println(aut.sum(arr));
  }
}
