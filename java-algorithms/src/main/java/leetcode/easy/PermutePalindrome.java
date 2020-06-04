package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/palindrome-permutation-lcci/">01.04. 回文排列</a>
 *
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * @author Li Yun
 * @date 2020/5/18 14:17
 */
public class PermutePalindrome {

  /**
   * 判断一个字符串是否是某个回文串的某一排列
   *
   * 思路：
   * 1. 回文串的特征是最多只有一个不成对字符
   * 2. 消消乐，成对出现的消除，看最后剩余的元素个数是否不大于1
   *
   * @param s 字符串
   * @return T：是回文串的某一排列，F：其他情况
   */
  public static boolean canPermutePalindrome(String s) {
    HashSet<Character> set = new HashSet<>();
    for (char c : s.toCharArray()){
      if (set.contains(c)){
        set.remove(c);
      }else {
        set.add(c);
      }
    }
    return set.size() <= 1;
  }

  /**
   * 判断一个字符串是否是某个回文串的某一排列
   *
   * 思路：
   * 1. 回文串的特征是最多只有一个不成对字符
   * 2. 统计每个字符出现的次数，看奇数次的元素个数是否不大于1
   *
   * @param s 字符串
   * @return T：是回文串的某一排列，F：其他情况
   */
  public static boolean canPermutePalindrome2(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()){
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int count = 0;
    for (Map.Entry<Character, Integer> entry : map.entrySet()){
      if ((entry.getValue().intValue() & 1) == 1) count++;      //如果是奇数次
    }
    return count <= 1;
  }


  /**
   * 判断一个字符串是否是某个回文串的某一排列
   *
   * 思路：
   * 1. 回文串的特征是最多只有一个不成对字符
   * 2. 统计每个字符出现的次数，看奇数次的元素个数是否不大于1
   * 3. 这里不使用 JDK 的哈希表，使用数组来完成（前提是字符中只有 ASCII 字符）
   *
   * @param s 字符串
   * @return T：是回文串的某一排列，F：其他情况
   */
  public static boolean canPermutePalindrome3(String s){
    int[] a = new int[128];           //标准 ASCII 码，也叫基础 ASCII 码，使用 7 位二进制数（剩下的1位二进制为0）来表示，共 128 个字符
    for (char c : s.toCharArray()){
      a[c]++;                         //字符 c 映射到对应下标，并且该位置计数加一
    }
    int count = 0;                    //统计奇数个元素个数
    for (int i : a){
      if ((i & 1) == 1) count++;
    }
    return count <= 1;
  }

}
