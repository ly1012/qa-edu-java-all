package leetcode.easy;

/**
 * <a href="https://leetcode-cn.com/problems/string-rotation-lcci/">面试题 01.09. 字符串轮转</a>
 *
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 *
 * 示例2:
 *  输入：s1 = "aa", "aba"
 *  输出：False
 *
 * 提示：
 * 字符串长度在[0, 100000]范围内。
 *

 * @author Li Yun
 * @date 2020/5/19 11:45
 */
public class IsFlipedString {

  /**
   * 给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成
   * @param s1 字符串
   * @param s2 字符串
   * @return
   */
  public static boolean isFlipedString(String s1, String s2) {
    return s1.equals(s2) || (s1.length() == s2.length() && (s2 + s2).contains(s1));
  }

}
