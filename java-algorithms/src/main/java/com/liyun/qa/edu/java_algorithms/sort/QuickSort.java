package com.liyun.qa.edu.java_algorithms.sort;

/**
 * 快速排序：从小到大排序
 *
 * 思路：分而治之，选取枢轴点 p（核心），剩余部分分区，小于 p 的部分 S1、大于等于 p 的部分 S2，然后对 S1、S2 排序
 *
 * 下面代码注释中，为了方便讲解，将 S1 部分的元素简记为 "小"，将 S2 部分的元素简记为 "大"
 *
 * @author Li Yun
 * @date 2020/5/19 21:52
 */
public class QuickSort {

  /**
   * 快速排序：从小到大排序
   * @param a 整型数组
   */
  public static void quickSort(int[] a){
    quickSort(a, 0, a.length - 1);
  }

  //递归排序
  private static void quickSort(int[] a, int low, int high){
    if (low < high){
      int m = partition(a, low, high);          //计算枢轴点的位置，并分区
      quickSort(a, low, m - 1);           //对小于枢轴点值的左边排序
      quickSort(a, m+1, high);             //对大于等于枢轴点值的右边排序
    }
  }

  //选取枢轴点并分区（算法核心）
  private static int partition(int[] a, int i, int j){
    int p = a[i];                       //将首位置的值作为枢轴点的值
    int m = i;                          //初始化枢轴点位置：将首位置作为枢轴点位置
    for (int k = i + 1; k <= j; k++){   //探索未知区域
      //【算法核心】数组的布局格式：[枢轴点：中][S1：小*][S2：大*][未知区域：密*]
      //中：枢轴点的值，比较对象，所以用 "中" 表示
      //小：小于 "中" 的元素
      //大：大于等于 "中" 的元素
      //密：和 "中" 的比较结果未知的元素
      if (a[k] < p){                    //k 位置是 "小"，将 m 右移一格，和 k 交换值（m 位置是小：和自己交换，大：和 k 交换）
        m++;                            //m 其实代表了 S1 部分的最右边的元素下标
        swap(a, m, k);
      }
      //a[k] > p 的情况，不做任何处理，只是简单的将 k 向右移一格（k++）。
      //因为 "大" 在 m 的右边，刚好符合快速排序的定义。
    }
    swap(a, i, m);                      //将 "中" 交换到 S1 的最右边，从而完成 "小-中-大" 布局
    return m;
  }

  //交换数组 a 中 i 位置和 j 位置的值
  private static void swap(int[] a, int i, int j){
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

}
