package com.liyun.qa.edu.java_algorithms.leetcode.easy;

/**
 * <a href="https://leetcode-cn.com/problems/single-number/">136. 只出现一次的数字</a>
 *
 * @author Li Yun
 * @date 2020/8/15 23:31
 */
public class _136_SingleNumber {

  /**
   * 使用异或特性
   * @param nums
   * @return
   */
  public int singleNumber(int[] nums) {
    if (nums.length == 1) return nums[0];
    for(int i = 1; i < nums.length; i++){
      nums[i] = nums[i] ^ nums[i-1];
    }
    return nums[nums.length-1];
  }

}
