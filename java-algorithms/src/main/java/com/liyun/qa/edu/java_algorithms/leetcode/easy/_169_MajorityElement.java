package com.liyun.qa.edu.java_algorithms.leetcode.easy;

/**
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 *
 * @author Li Yun
 * @date 2020/8/16 10:40
 *
 * @see Interview_17_10_FindMajorElement
 */
public class _169_MajorityElement {

  public int majorityElement(int[] nums) {
    int major = nums[0];
    int count = 0;
    for(int num : nums){
      if(count == 0){
        major = num;
      }
      if(major == num){
        count++;
      }else{
        count--;
      }
    }
    return major;
  }

}
