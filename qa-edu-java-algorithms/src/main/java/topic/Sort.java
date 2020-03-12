package topic;

/**
 * 排序算法，从小到大 <br>
 * 创建时间：2020/3/7 14:45<br>
 * 作者：李云
 */
public class Sort {

  /**
   * 冒泡排序
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
          a[j] = a[j] ^ a[j+1];
          a[j+1] = a[j] ^ a[j+1];
          a[j] = a[j] ^ a[j+1];
          change = true;
        }
      }
    }
  }

}
