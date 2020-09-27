package com.liyun.qa.edu.java_algorithms.leetcode.easy;

/**
 * 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author Li Yun
 * @date 2020/8/19 12:03
 */
public class _14_LongestCommonPrefix {

  /**
   * 暴力循环
   * @param strs
   * @return
   */
  public String longestCommonPrefix(String[] strs) {
    if(strs.length == 0) return "";

    StringBuffer sb = new StringBuffer();
    outer:
    for(int i = 0; i < strs[0].length(); i++){                //遍历第一个字符串的每个字符
      char c = strs[0].charAt(i);
      for(int j = 1; j < strs.length; j++){                   //将数组中第二个及以后的字符串对应位置的字符与当前字符比较
        if(strs[j].length() <= i || strs[j].charAt(i) != c){  //如果字符串遍历完或对应位置不等于当前字符，结束整个遍历
          break outer;
        }
      }
      sb.append(c);                                           //如果所有字符串对应位置的字符都存在且相等，追加到前缀后面
    }
    return sb.toString();
  }

}
