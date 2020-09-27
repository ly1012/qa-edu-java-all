package com.liyun.qa.edu.java_algorithms.leetcode.easy;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 *
 * @author Li Yun
 * @date 2020/8/17 14:13
 */
public class _198_HouseRobber {

  /**
   * 动态规划 + 滚动数组
   * @param nums
   * @return
   */
  public int rob(int[] nums) {
    int p = 0;      // Sn-2
    int q = 0;      // Sn-1
    for(int i = 0; i < nums.length; i++){
      nums[i] = q > p + nums[i] ? q : p + nums[i];  //递推公式：s_n = Math.max(s_n-1, s_n-2 + h_n)
      p = q;
      q = nums[i];
    }
    return nums.length == 0 ? 0 : nums[nums.length-1];
  }

}
