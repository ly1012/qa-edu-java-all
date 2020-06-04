package leetcode.easy;

/**
 * <a href="https://leetcode-cn.com/problems/compress-string-lcci/">面试题 01.06. 字符串压缩</a>
 *
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 *
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * 提示：
 *
 * 字符串长度在[0, 50000]范围内。
 *
 * @author Li Yun
 * @date 2020/5/19 12:04
 */
public class CompressString {

  /**
   * 压缩字符串
   * @param s 字符串
   * @return 压缩后的字符串
   */
  public static String compressString(String s) {
    if (s.length() < 2) return s;               //字符串长度小于等于 1，直接返回

    char[] chars = s.toCharArray();

    StringBuffer buffer = new StringBuffer();
    char c = chars[0];                          //当前计数字符
    int count = 1;                              //当前计数字符的统计次数

    for (int i = 1; i < chars.length; i++){
        if (c == chars[i]){                     //如果下一个字符等于当前字符，计数加一
          count++;
        }else {                                 //否则，写入当前压缩数据，并重置当前计数字符
          buffer.append(c).append(count);
          c = chars[i];
          count = 1;
        }
    }
    buffer.append(c).append(count);             //写入最后一次的压缩数据

    return (buffer.toString().length() >= s.length()) ? s : buffer.toString();
  }

}
