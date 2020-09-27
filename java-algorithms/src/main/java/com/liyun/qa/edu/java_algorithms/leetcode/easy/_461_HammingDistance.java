package com.liyun.qa.edu.java_algorithms.leetcode.easy;

/**
 * 461. 汉明距离
 * https://leetcode-cn.com/problems/hamming-distance/
 *
 * @author Li Yun
 * @date 2020/8/18 10:01
 */
public class _461_HammingDistance {

  /**
   * 异或运算 + 取余
   * @param x
   * @param y
   * @return
   */
  public int hammingDistance(int x, int y) {
    int m = x ^ y;
    int count = 0;
    while(m != 0){                //整数除 2 取余，转为二进制
      if(m % 2 == 1) count++;     //取余数，计算汉明距离
      m = m / 2;
    }
    return count;
  }

  /**
   * 异或 + Java API
   * @param x
   * @param y
   * @return
   */
  public int hammingDistance2(int x, int y) {
    return Integer.bitCount(x ^ y);
  }

}
