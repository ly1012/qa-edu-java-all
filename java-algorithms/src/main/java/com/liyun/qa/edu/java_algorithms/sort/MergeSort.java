package com.liyun.qa.edu.java_algorithms.sort;

/**
 * 归并排序：从小到大排序
 *
 * 思路：分而治之，先二分，对每一个排序，再合并这两个排序后的部分
 *
 * @author Li Yun
 * @date 2020/5/17 23:03
 */
public class MergeSort {

  /**
   * 归并排序
   * @param a 要排序的数组
   */
  public static void mergeSort(int a[]){
    mergeSort(a, 0, a.length - 1);
  }

  private static void mergeSort(int[] a, int low, int high){
    if (low < high){                        //递归终止条件：对长度为 1 的数组排序，即 low = high
      int mid = low + (high - low)/2;       //防止 (low + high)/2 造成 int 溢出
      mergeSort(a, low, mid);               //对拆分的左子数组排序
      mergeSort(a, mid+1, high);       //对拆分的右子数组排序
      merge(a, low, mid, high);             //合并左、右已排序子数组
    }
  }

  //合并两个已排序子数组
  //思路：因为子数组已排序，依次取两个队列的头比较，并存入新数组
  //subarray1 = a[low..mid]， subarray2 = a[mid+1..high]，且两个子数组都已排序
  private static void merge(int[] a, int low, int mid, int high){
    int[] b = new int[high - low + 1];            //启用一个临时数组，用于存放合并后有序的元素
    int k = 0;                                    //临时数组，选择的元素当前应放置的位置（下标）
    int left = low;                               //左边子数组的当前遍历位置
    int right = mid + 1;                          //右边子数组的当前遍历位置
    while (left <= mid && right <= high){         //如果当前遍历位置未超过范围
      b[k++] = (a[left] < a[right]) ? a[left++] : a[right++];   //比较左右两个子数组最前面元素的大小，小的存入临时数组，并将遍历位置右移一格
    }
    while(left <= mid){                           //如果左边子数组还有未遍历元素，将剩余元素追加到临时数组末尾
      b[k++] = a[left++];
    }
    while (right <= high){                        //如果右边子数组还有未遍历元素，将剩余元素追加到临时数组末尾。注意：不存在左、右子数组都有未遍历元素的情况。
      b[k++] = a[right++];
    }
    for (int i = 0; i < b.length; i++){           //将合并排序后的元素，填充进原数组
      a[low+i] = b[i];
    }
  }

}
