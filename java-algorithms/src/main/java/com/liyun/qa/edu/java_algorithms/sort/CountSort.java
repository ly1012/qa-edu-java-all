package com.liyun.qa.edu.java_algorithms.sort;

/**
 * 计数排序
 *
 * 使用前提：
 * 1. 数组元素必须是整数
 * 2. 排序元素的取值要在一定范围内（范围不能太大），并且比较集中。
 *
 * 扩展阅读：
 * 1. [一文弄懂计数排序算法！](https://www.cnblogs.com/xiaochuan94/p/11198610.html)
 * 2. [什么是计数排序？](https://www.cnblogs.com/kyoner/p/10604781.html)
 *
 * @author Li Yun
 * @date 2020/5/20 9:47
 */
public class CountSort {

  public static int[] countSort(int[] a){
    if (a.length <= 1) return a;          //长度为 0 或 1，不需要排序，直接返回

    //查找原数组最大值、最小值
    int max = a[0];
    int min = a[0];
    for (int i = 0; i < a.length; i++){
      if (a[i] > max) max = a[i];
      if (a[i] < min) min = a[i];
    }

    //计数：原数组每个元素出现的次数
    int range = max - min + 1;            //数组 [min...max] 的范围长度
    int[] count = new int[range];         //计数数组
    for (int i = 0; i < a.length; i++){
      count[a[i] - min]++;
    }

    //计数变形：计数数组新元素的值是前面元素累加之和的值
    for (int i = 1; i < count.length; i++){
      count[i] += count[i-1];
    }

    //排序输出
    int[] sorted = new int[a.length];
    for (int i = a.length - 1; i >= 0; i--){    //倒序遍历，保证相同元素还是原数组的顺序
      sorted[count[a[i] - min] -1] = a[i];
      count[a[i] - min]--;
    }

    return sorted;
  }

}
