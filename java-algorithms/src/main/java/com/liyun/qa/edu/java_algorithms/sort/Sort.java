package com.liyun.qa.edu.java_algorithms.sort;

/**
 * 排序算法，从小到大 <br>
 *
 * <a href="https://visualgo.net/zh/sorting">排序算法可视化演示</a>
 *
 * @author Li Yun
 * @date 2020/3/7 14:45
 */
public class Sort {

  //交换数组中两个下标位置的值
  //交换数组 a 中 i 位置和 j 位置的值
  private static void swap(int[] a, int i, int j){
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  /**
   * 冒泡排序：冒泡最小值或最大值到末尾
   * @param a 整数数组
   */
  public static void bubbleSort(int[] a){
    // 元素 a[0]..a[n-1]
    int n = a.length;
    // 一次从左到右的检查中是否交换过，如果没有交换过（即change=false)说明已经是从小到大排序，结束排序算法
    boolean change = true;
    // i 表示一趟排序的长度，或者理解为一趟排序到哪个下标的元素为止
    for (int i = n-1; i >= 1 && change; i--){
      change = false;
      for(int j = 0; j < i; j++){
        // 比较大小，大的放后面。一趟排序完成后，最大的元素将位于本次排序的最末端。
        if(a[j] > a[j+1]){
          swap(a, j , j+1);
          change = true;
        }
      }
    }
  }

  /**
   * 选择排序：选择最小值或最大值到头部
   * @param a 整数数组
   */
  public static void selectionSort(int[] a){
    int x;                                  //最小值元素下标
    for (int i = 0; i < a.length - 1; i++){ //循环 n-1 次。最后一个元素不需要排序，因为肯定是最大的
      x = i;                                //将第一个未排序元素设为最小值，这里使用最小值元素的下标表示
      for (int j = i+1; j < a.length; j++){
        if (a[j] < a[x]){
          x = j;
        }
      }
      if (x != i){                          //如果当前检查元素不是最小值，交换位置
        swap(a, x , i);
      }
    }
  }

  /**
   * 插入排序：提取第一个未排序元素，插入已排序元素中间
   * @param a 整数数组
   */
  public static void insertionSort(int[] a){
    for (int i = 1; i < a.length; i++){   //从 1 开始，第一个元素作为初始排序过的元素
      int x = a[i];                       //提取第一个未排序元素，作为要插入的元素，同时将该位置视为空
      int j = i - 1;                      //对已排序元素倒序检查，提取元素的左边元素（下标为 i-1）作为第一个检查元素
      for (; j >= 0 && a[j] > x; j--){    //对已排序元素倒序检查，直到最左边的元素（下标为 0）结束
                                          //如果已排序元素大于插入元素
        a[j+1] = a[j];                    //已排序元素右移一格
      }
      a[j+1] = x;                         //插入提取的元素，如果当前已排序元素不大于提取的元素，则在该元素右边插入提取元素
                                          //1. 已排序元素都大于提取元素，j = -1，在 0 = -1 + 1 位置插入提取元素（已排序元素整体右移一格，0 位置是空的）
                                          //2. 已排序元素中的某个元素不大于提取元素，j = 该元素下标，在该元素右边一格插入提取元素（该元素右边的已排序元素整体右移一格，所以该元素右边一格位置是空的）
    }
  }



}
