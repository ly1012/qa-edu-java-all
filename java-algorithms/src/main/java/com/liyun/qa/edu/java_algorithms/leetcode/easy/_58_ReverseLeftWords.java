package com.liyun.qa.edu.java_algorithms.leetcode.easy;

/**
 * <a href="https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/">面试题58 - II. 左旋转字符串</a>
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *  
 * 限制：1 <= k < s.length <= 10000
 *
 * @author Li Yun
 * @date 2020/5/18 22:59
 */
public class _58_ReverseLeftWords {

  /**
   * 左旋转字符串
   *
   * 思路：使用 substring 方法
   *
   * @param s 字符串
   * @param k 左旋转长度
   * @return 左旋转后的字符串
   */
  public static String reverseLeftWords(String s, int k) {
      return s.substring(k) + s.substring(0, k);
  }

  /**
   * 左旋转字符串
   *
   * 思路：通过一个辅助数组来实现
   *
   * @param s 字符串
   * @param k 左旋转长度
   * @return 左旋转后的字符串
   */
  public static String reverseLeftWords2(String s, int k) {
    char[] chars = s.toCharArray();
    char[] tmp = new char[k];
    int n = chars.length;
    for (int i = 0; i < n; i++){
      if (i < k){                             //临时存储待左旋转的字符序列
        tmp[i] = chars[i];
      }else {                                 //剩余字符序列前移到头部
        chars[i-k] = chars[i];
      }
    }
    for (int i = 0; i < tmp.length; i++){     //将左旋转字符序列追加到剩余字符序列的末尾
      chars[n-k+i] = tmp[i];
    }
    return new String(chars);
  }

}
