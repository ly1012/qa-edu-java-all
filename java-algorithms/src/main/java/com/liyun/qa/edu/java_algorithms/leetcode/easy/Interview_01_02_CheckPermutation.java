package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/check-permutation-lcci/">面试题 01.02. 判定是否互为字符重排</a>
 *
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 *
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * @author Li Yun
 * @date 2020/5/19 16:25
 */
public class Interview_01_02_CheckPermutation {

  private static boolean checkParam(String s1, String s2){
    return s1 == null || s2 == null || s1.length() != s2.length();
  }


  /**
   * 判定是否互为字符重排
   *
   * 思路：字符数组排序，比较相同位置字符是否一样
   *
   * @param s1 第一个字符串
   * @param s2 第二个字符串
   * @return True:互为重排，False：不是互为重排
   */
  public static boolean checkPermutation(String s1, String s2) {
    if (checkParam(s1, s2)) return false;

    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    Arrays.sort(c1);                      //第一个字符数组排序
    Arrays.sort(c2);                      //第二个字符数组排序

    for (int i = 0; i < c1.length; i++){  //检查相同位置的值是否相同
      if (c1[i] != c2[i]) return false;
    }

    return true;
  }

  /**
   * 判定是否互为字符重排
   *
   * 思路：散列表，HashMap 统计字符出现次数
   *
   * @param s1 第一个字符串
   * @param s2 第二个字符串
   * @return True:互为重排，False：不是互为重排
   */
  public static boolean checkPermutation2(String s1, String s2) {
    if (checkParam(s1, s2)) return false;

    //对第一个字符串的字符计数
    Map<Character, Integer> map1 = new HashMap<>();
    for (char c : s1.toCharArray()) map1.put(c, map1.getOrDefault(c, 0) + 1);

    //对第二个字符串的字符计数
    Map<Character, Integer> map2 = new HashMap<>();
    for (char c : s2.toCharArray()) map2.put(c, map2.getOrDefault(c, 0) + 1);

    //检查两个字符串的计数是否相等
    Iterator<Map.Entry<Character, Integer>> iterator = map1.entrySet().iterator();
    while (iterator.hasNext()){
      Map.Entry<Character, Integer> entry = iterator.next();
      Character key = entry.getKey();
      Integer value = entry.getValue();
      if (value == null){
        if (!(map2.get(key) == null && map2.containsKey(key))) return false;
      }else {
        if (!value.equals(map2.get(key))) return false;
      }
    }

    return true;
  }

  /**
   * 判定是否互为字符重排
   *
   * 思路：散列表，数组统计字符出现次数
   *
   * @param s1 第一个字符串
   * @param s2 第二个字符串
   * @return True:互为重排，False：不是互为重排
   */
  public static boolean checkPermutation3(String s1, String s2) {
    if (checkParam(s1, s2)) return false;

    //优化版：
    int[] counts = new int[65535];            //分配散列表
    for (int i = 0; i < s1.length(); i++){    //计数
      counts[s1.charAt(i)]++;
      counts[s2.charAt(i)]--;
    }

    for (int i = 0; i < counts.length; i++){  //检查计数
      if (counts[i] != 0) return false;
    }

    /*
    //初版：
    //对第一个字符串计数
    int[] c1 = new int[65535];
    for (char c : s1.toCharArray()) c1[c]++;

    //对第二个字符串计数
    int[] c2 = new int[65535];
    for (char c : s2.toCharArray()) c2[c]++;

    //检查两个字符串的计数是否相等
    for (int i = 0; i < c1.length; i++){
      if (c1[i] != c2[i]) return false;
    }
    */

    return true;
  }


}
