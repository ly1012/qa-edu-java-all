package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * @author Li Yun
 * @date 2020/8/18 11:10
 */
public class _448_FindAllNumbersDisappearedInAnArray {

  /**
   * 哈希表
   * @param nums
   * @return
   */
  public List<Integer> findDisappearedNumbers(int[] nums) {
    //通过哈希，标记已存在元素的次数为 1
    int[] count = new int[nums.length];
    for (int num : nums){
      count[num-1] = 1;
    }

    //查找出现次数为 0 的元素，即缺失元素
    List<Integer> result = new LinkedList<Integer>();
    for (int i = 0; i < count.length; i++){
      if (count[i] == 0) result.add(i+1);
    }
    return result;
  }

  /**
   * 原地标记
   * @param nums
   * @return
   */
  public List<Integer> findDisappearedNumbers2(int[] nums) {
    //标记出现过的元素，其排序后的下标位置值为负数
    for(int i : nums){
      i = Math.abs(i);
      if (nums[i-1] > 0){
        nums[i-1] = nums[i-1] * -1;
      }
    }

    //找出值为正数的下标
    List<Integer> result = new LinkedList<Integer>();
    for(int i = 0; i< nums.length; i++){
      if (nums[i] > 0){
        result.add(i+1);
      }
    }

    return result;
  }

}
