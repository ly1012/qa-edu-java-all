package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/
 *
 * @author Li Yun
 * @date 2020/8/19 10:38
 */
public class _13_RomanToInteger {

  /**
   * 判断相邻罗马数字的大小
   * 使用 Map 作为字典
   * @param s
   * @return
   */
  public int romanToInt(String s) {
    // 字典表
    Map<Character,Integer> dict = new HashMap<>();
    dict.put('I', 1);
    dict.put('V', 5);
    dict.put('X', 10);
    dict.put('L', 50);
    dict.put('C', 100);
    dict.put('D', 500);
    dict.put('M', 1000);

    char[] chars = s.toCharArray();
    int sum = 0;
    for(int i = 0; i < chars.length - 1; i++){
      if(dict.get(chars[i]) < dict.get(chars[i+1]) ){
        sum += (dict.get(chars[i]) * -1);
      }else{
        sum += dict.get(chars[i]);
      }
    }
    sum += dict.get(chars[chars.length-1]);
    return sum;
  }

  /**
   * 判断相邻罗马数字的大小
   * 优化版：使用 Switch 模拟字典、缓存
   * @param s
   * @return
   */
  public int romanToInt2(String s) {
    int sum = 0;
    int preNum = getValue(s.charAt(0));
    for(int i = 1;i < s.length(); i ++) {
      int num = getValue(s.charAt(i));
      if(preNum < num) {
        sum -= preNum;
      } else {
        sum += preNum;
      }
      preNum = num;
    }
    sum += preNum;
    return sum;
  }

  private int getValue(char ch) {
    switch(ch) {
      case 'I': return 1;
      case 'V': return 5;
      case 'X': return 10;
      case 'L': return 50;
      case 'C': return 100;
      case 'D': return 500;
      case 'M': return 1000;
      default: return 0;
    }
  }


  /**
   * 首先将所有的组合可能性列出并添加到哈希表中
   * 然后对字符串进行遍历，由于组合只有两种，一种是 1 个字符，一种是 2 个字符，其中 2 个字符优先于 1 个字符
   * 先判断两个字符的组合在哈希表中是否存在，存在则将值取出加到结果 ans 中，并向后移2个字符。不存在则将判断当前 1 个字符是否存在，存在则将值取出加到结果 ans 中，并向后移 1 个字符
   * 遍历结束返回结果 ans
   *
   * 作者：guanpengchn
   * 链接：https://leetcode-cn.com/problems/roman-to-integer/solution/hua-jie-suan-fa-13-luo-ma-shu-zi-zhuan-zheng-shu-b/
   * @param s
   * @return
   */
  public int romanToInt3(String s) {
    Map<String, Integer> map = new HashMap<>();
    map.put("I", 1);
    map.put("IV", 4);
    map.put("V", 5);
    map.put("IX", 9);
    map.put("X", 10);
    map.put("XL", 40);
    map.put("L", 50);
    map.put("XC", 90);
    map.put("C", 100);
    map.put("CD", 400);
    map.put("D", 500);
    map.put("CM", 900);
    map.put("M", 1000);

    int ans = 0;
    for(int i = 0;i < s.length();) {
      if(i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {
        ans += map.get(s.substring(i, i+2));
        i += 2;
      } else {
        ans += map.get(s.substring(i, i+1));
        i ++;
      }
    }
    return ans;
  }

}
