package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/valid-parentheses/">20. 有效的括号</a>
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * @author Li Yun
 * @date 2020/5/20 21:40
 */
public class _20_IsValidBracketsExpression {

  /**
   * 有效的括号
   *
   * 思路：
   * 1. 一个有效的表达式，从内部对外部每一对括号都是配对的
   * 2. 从内部开始，每配对一对括号，就删除这对括号，如果不配对则表示无效表达式
   * 3. 如果最后没有多余的括号，则为有效表达式
   * 4. 使用栈这种有回溯特性的数据结构
   *
   * @param s 字符串
   * @return
   */
  public static boolean isValid(String s) {
    if (s.isEmpty()) return true;

    //栈对象
    Stack<Character> stack = new Stack();

    char[] chars = s.toCharArray();
    for (char c : chars){
      if (c == '(' || c == '[' || c == '{'){          //如果是左括号，则左括号入栈
        stack.push(c);
      }else if(c == ')' || c == ']' || c == '}'){     //如果是右括号，则出栈检测
        if (stack.isEmpty()) return false;            //如果栈为空，表明不匹配
        char left = stack.pop();                      //出栈
        if (!(                                        //检测出栈括号和当前括号是否配对
            (left == '(' && c == ')') || (left == '[' && c == ']') || (left == '{' && c == '}')
        )) return false;
      }
    }

    return stack.isEmpty();                           //如果栈为空，则有效
  }

  /**
   * 有效的括号
   *
   * 思路：
   * 1. {@link _20_IsValidBracketsExpression#isValid(String)} 的优化版
   * 2. 右括号入栈，遍历到右括号时弹出
   *
   * @param s
   * @return
   */
  public static boolean isValid2(String s) {
    if ((s.length() & 1) == 1) {                              //如果字符串字符个数为奇数，是无效表达式
      return false;
    }
    Stack<Character> stack = new Stack<>();
    char[] chs = s.toCharArray();
    for (int i = 0; i < chs.length; i++) {
      if (chs[i] == '{') {                                    //如果是左括号，对应的右括号入栈
        stack.push('}');
      } else if (chs[i] == '(') {
        stack.push(')');
      } else if (chs[i] == '[') {
        stack.push(']');
      } else if (stack.isEmpty() || stack.pop() != chs[i]) {  //如果栈为空，是无效表达式
                                                              //如果不是左括号（即右括号），出栈比较，不相同则无效
        return false;
      }
    }
    return stack.isEmpty();
  }

  /**
   * 有效的括号
   *
   * 思路：
   * 1. 前面的优化版，使用数组模拟栈
   *
   * @param s
   * @return
   */
  public static boolean isValid3(String s) {
    if ((s.length() & 1) == 1) return false;  //如果字符串字符个数为奇数，是无效表达式

    char[] stack = new char[s.length()];      //用数组模拟栈

    int p = 0;                                //栈顶指针

    for (char c : s.toCharArray()) {
      if (c == '(') {                         //如果是左括号，则右括号入栈
        stack[p++] = ')';
      } else if (c == '[') {
        stack[p++] = ']';
      } else if (c == '{') {
        stack[p++] = '}';
      } else if (p == 0 || stack[--p] != c) { //当字符是右括号时：
                                              //1. 如果 p == 0，即 p 是初始值，说明没有左括号可以配对，是无效表达式
                                              //2. 如果 p != 0，栈顶指针先左移（因为前面多加了1），再出栈检测
        return false;
      }
    }

    return p == 0;
  }

}
