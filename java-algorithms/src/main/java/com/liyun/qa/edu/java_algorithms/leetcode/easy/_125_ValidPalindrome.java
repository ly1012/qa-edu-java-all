package com.liyun.qa.edu.java_algorithms.leetcode.easy;

/**
 * 125. 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 *
 * @author Li Yun
 * @date 2020/8/19 13:06
 */
public class _125_ValidPalindrome {

  /**
   * 从两端遍历
   * @param s
   * @return
   */
  public boolean isPalindrome(String s) {
    int low = 0;
    int high = s.length() - 1;
    while(low < high){                          //当未遍历到中间时
      char ls = s.charAt(low);                  //获取左边的值并判断是否合法，不合法则跳过
      if(!isValid(ls)){
        low++;
        continue;
      }
      char hs = s.charAt(high);                 //获取右边的值并判断是否合法，不合法则跳过
      if (!isValid(hs)){
        high--;
        continue;
      }
      if (toLowerCase(ls) != toLowerCase(hs)){  //如果不相等，则不是回文串，直接返回 false
        return false;
      }else {
        low++;
        high--;
      }
    }
    return true;
  }

  private boolean isValid(char c){
    if((c >= 65 && c <= 90)         //大写字母：A-Z
        || (c >= 97 && c <= 122)    //小写字母：a-z
        || (c >= 48 && c <= 57)     //数字
    ) return true;
    return false;
  }

  private char toLowerCase(char c){
    if (c >= 65 && c <= 90) return (char)(c+32);
    return c;
  }

}
