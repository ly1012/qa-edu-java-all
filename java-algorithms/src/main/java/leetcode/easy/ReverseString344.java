package leetcode.easy;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-string/">344. 反转字符串</a>
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * @author Li Yun
 * @date 2020/5/18 12:06
 */
public class ReverseString344 {

  /**
   * 反转字符串
   * @param s 给定的字符串
   * @return 反转后的字符串
   */
  public static String reverse(String s){
    return new StringBuffer(s).reverse().toString();
  }

  /**
   * 原地反转字符数组
   *
   * 思路：将数组分成长度相等的左右两部分，从中间位置开始，往两边依次遍历互换元素。
   * 这个思路和等差数列的求和类似，等差数列中是两个元素求和，这里是两个元素交换位置。
   *
   * 假设数组长度为 l，数组的最大下标为 n = l-1
   * 1. 如果 l 是偶数，则 n 是奇数，n-1 是偶数，分隔线左侧下标 (n-1) >> 1 刚好整除，左右两部分长度相等。
   * 2. 如果 l 是奇数，则 n 是偶数，n-1 是奇数，分隔线左侧下标 (n-1) >> 1 不能整除，
   * 取的是分隔线左边一格元素的下标，中间位置元素保持不动，左右两部分长度相等。
   *
   * @param value 字符数组
   */
  public static void reverse(char[] value){
    int n = value.length - 1;                 //数组最大下标
    //从分隔线位置开始，向两侧遍历
    for (int j = (n-1) >> 1; j >= 0; j--) {   //j 是左边部分的遍历下标，注意：这里是计算分隔线左边一格位置，所以使用 n-1。
      int k = n - j;                          //k 是右边部分的遍历下标
      //元素互换
      char cj = value[j];                     //提取左边元素值
      char ck = value[k];                     //提取右边元素值
      value[j] = ck;                          //将右边元素值赋值到左边元素的位置
      value[k] = cj;                          //将左边元素值赋值到右边元素的位置
    }
  }

  /**
   * 原地反转字符数组
   *
   * 思路：和 {@link ReverseString344#reverse(char[])} 刚好相反，从两侧向中间遍历
   *
   * 扩展：使用递归也可以实现
   *
   * @param value 字符数组
   */
  public static void reverse2(char[] value){
    int low = 0;
    int high = value.length - 1;
    while (low < high) {
      swap(value, low++, high--);;
    }
  }

  private static void swap(char[] s, int i, int j) {
    char t = s[i];
    s[i] = s[j];
    s[j] = t;
  }

}
