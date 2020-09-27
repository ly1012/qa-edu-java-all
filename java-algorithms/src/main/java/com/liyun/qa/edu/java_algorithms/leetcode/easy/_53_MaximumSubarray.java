package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  * 阿里在线测试，问题5：给定一个整数数组，例如 -5 2 6 8 -20 -10 5 -10 20 -5 -6，求连续整数之最大和
 *  * 原题为 <a href="https://leetcode-cn.com/problems/maximum-subarray/">53. 最大子序和</a>
 *
 * @author Li Yun
 * @date 2020/8/15 20:40
 */
public class _53_MaximumSubarray {

  //贪心解法（动态规划解法代码一样）
  //如果前面的连续整数序列和小于 0，则从当前位置开始新的序列，将当前值作为当前和
  public int sum(int[] arr){
    int sum = arr[0];       //当前和
    int max = arr[0];       //最大和
    for(int i = 1; i < arr.length; i++){
      sum = sum < 0 ? arr[i] : sum+arr[i];
      max = Math.max(max, sum);
    }
    return max;
  }

  //题目意思理解错了，先不删除，留着备份
  public int sumOther(int[] arr){
    Arrays.sort(arr);   //对数组排序
    List<Integer> list = new ArrayList<>();
    int sum = 0;               //当前连续整数序列和
    boolean flag = false;      //是否是连续整数序列
    for(int i = 0; i <  arr.length-1; i++){
      if(arr[i] == arr[i+1]){
        sum += arr[i];
        flag = true;
      }else {
        if (flag){              //如果前面是连续的，到这里不连续
          sum += arr[i];        //加上该位置的值
          flag = false;         //重置标志位，寻找下一个连续整数序列
          list.add(sum);        //将当前连续整数序列和，加入列表
        }
        sum = 0;
      }
    }

    int max = list.get(0);
    for (int i = 0; i < list.size(); i++){
      max = list.get(i) > max ? list.get(i) : max;
    }
    return max;
  }

}
