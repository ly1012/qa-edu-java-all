package com.liyun.qa.edu.java_algorithms.leetcode.easy;

/**
 * 26. 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author Li Yun
 * @date 2020/8/20 14:36
 */
public class _26_RemoveDuplicatesFromSortedArray {

  /**
   * 原地算法：双指针法
   * @param nums
   * @return
   */
  public int removeDuplicates(int[] nums) {
    if(nums.length < 2) return nums.length;
    int idx = 0;                            // idx 是慢指针
    for(int i = 1; i < nums.length; i++){   // i 是快指针
      if(nums[idx] != nums[i]){
        nums[++idx] = nums[i];
      }
    }
    return idx+1;
  }

}
