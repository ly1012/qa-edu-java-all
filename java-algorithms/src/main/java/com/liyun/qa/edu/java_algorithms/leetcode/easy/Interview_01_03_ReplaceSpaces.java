package com.liyun.qa.edu.java_algorithms.leetcode.easy;


/**
 * <a href="https://leetcode-cn.com/problems/string-to-url-lcci/">面试题 01.03. URL化</a>
 *
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。
 * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 * 示例1:
 *
 *  输入："Mr John Smith    ", 13
 *  输出："Mr%20John%20Smith"
 *
 * 示例2:
 *
 *  输入："               ", 5
 *  输出："%20%20%20%20%20"
 * 提示：
 *
 * 字符串长度在[0, 500000]范围内。
 *
 *
 * @author Li Yun
 * @date 2020/5/19 15:12
 */
public class Interview_01_03_ReplaceSpaces {

  /**
   * URL化，将字符串中的空格全部替换为%20
   *
   * 思路：使用 JDK 自带 API，substring 和 replaceAll
   *
   * @param s       字符串
   * @param length  要 URL 化的长度
   * @return
   */
  public static String replaceSpaces(String s, int length) {
    return s.substring(0, length).replaceAll(" ","%20");
  }

  /**
   * URL化，将字符串中的空格全部替换为%20
   *
   * 思路：使用新数组来保存 URL 化后的字符
   *
   * @param s       字符串
   * @param length  要 URL 化的长度
   * @return
   */
  public static String replaceSpaces2(String s, int length) {
    char[] origin = s.toCharArray();

    int count = 0;
    for (int i = 0; i < length; i++){                   //统计空格的个数
      if (origin[i] == ' ') count++;
    }

    char[] chars = new char[length - count + count*3];  //存放 URL 化后字符的新数组
    int idx = 0;
    for (int i = 0; i < length; i++){
      if (origin[i] == ' '){                            //如果是空格，存放转义字符
        chars[idx++] = '%';
        chars[idx++] = '2';
        chars[idx++] = '0';
      }else {                                           //非空格，存放原字符
        chars[idx++] = origin[i];
      }
    }

    return new String(chars);
  }

}
