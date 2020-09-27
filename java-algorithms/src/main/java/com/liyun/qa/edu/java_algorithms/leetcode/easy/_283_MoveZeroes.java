package com.liyun.qa.edu.java_algorithms.leetcode.easy;

/**
 * 283. 移动零
 *https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author Li Yun
 * @date 2020/8/17 22:46
 */
public class _283_MoveZeroes {

  /**
   * 根据 0 的个数计算要移动的步长，移动后将原来的位置设为 0（相当于交换位置）。
   * @param nums
   */
  public void moveZeroes(int[] nums) {
    int cnt = 0;
    for(int i = 0; i < nums.length; i++){
      if(nums[i] == 0){
        cnt++;
      }else if(cnt > 0){
        nums[i-cnt] = nums[i];
        nums[i] = 0;
      }
    }
  }

}
