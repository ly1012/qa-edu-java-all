package com.liyun.qa.edu.java_algorithms.leetcode.easy;

/**
 * <a href="https://leetcode-cn.com/problems/climbing-stairs/">70. 爬楼梯</a>
 *
 * @author Li Yun
 * @date 2020/8/15 21:14
 */
public class _70_ClimbingStairs {

  /**
   * 递归解法（复杂度太高）
   *
   * 1. 终止条件：n <= 2
   * 2. 递归公式：f(n) = f(n-1) + f(n-2)
   * @param n
   * @return
   */
  public int climbStairs(int n) {
    return n > 2 ? climbStairs(n-1) + climbStairs(n-2) : n;
  }

  /**
   * 动态规划解法：容易理解
   * @param n
   * @return
   */
  public int climbStairs2(int n){
    if (n <=2 ) return n;
    int p = 1;      //f(n-2) = f(3-2) = f(1) = 1
    int q = 2;      //f(n-1) = f(3-1) = f(2) = 2
    int sum = 0;    //f(n)
    for(int i = 3; i <= n; i++){
      sum = p + q;
      p = q;
      q = sum;
    }
    return sum;
  }

  /**
   * 动态规划解法：兼容 n 从 1 开始
   *
   * 1. 思路：先求 f(n-2) 和 f(n-1) 值，再计算 f(n) = f(n-2) + f(n-1)。
   * 2. 细节：根据思路的初步代码，反推 p、q、sum 的初始值。
   *
   * f(1) = f(-1) + f(0) = 1 => sum = p + q => 1 = 0 + 1
   * f(2) = f(0) + f(1) = 2 => sum = p + q => 2 = 1 + 1
   *
   * n         1  2  3  4  5
   * sum       1  2  3  5  8
   *           p  q  sum
   *
   * sum = p + q
   *
   * @param n
   * @return
   */
  public int climbStairs3(int n){
    int p;          //f(n-2)
    int q = 0;      //f(n-1)
    int sum = 1;    //f(n)
    for(int i = 1; i <= n; i++){   // i = 1 表示计算 n = 1 时的情况，i 只是控制循环次数，和 f(x) 没有直接关系
      p = q;
      q = sum;
      sum = p + q;                 //当 n = 1 时，1 = 0 + 1，所以初始值 q = 0, sum = 1, p 初始值无所谓
    }
    return sum;
  }

}
