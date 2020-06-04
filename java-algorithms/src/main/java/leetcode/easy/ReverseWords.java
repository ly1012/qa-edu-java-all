package leetcode.easy;

/**
 * <a href="https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/">面试题58 - I. 翻转单词顺序</a>
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @author Li Yun
 * @date 2020/5/19 10:00
 */
public class ReverseWords {

  /**
   * 翻转单词顺序
   *
   * 思路：数组反转
   *
   * @param s 英文句子
   * @return 翻转后的字符串
   */
  public static String reverseWords(String s) {
    String[] words = s.trim().split(" +");     //按一个或多个空格分隔，得到一组单词
    int low = 0;
    int high = words.length - 1;
    while (low < high){                        //反转单词数组
      String t = words[low];
      words[low++] = words[high];
      words[high--] = t;
    }
    return String.join(" ", words);  //使用一个空格连接单词组
  }

  /**
   * 翻转单词顺序
   *
   * 思路：逆序追加
   *
   * @param s 英文句子
   * @return 翻转后的字符串
   */
  public static String reverseWords2(String s) {
    String[] words = s.trim().split(" ");     //按一个或多个空格分隔，得到一组单词，包含空
    StringBuffer buffer = new StringBuffer();
    for(int i = words.length-1; i >= 0; i--){        //逆序组装字符串
      if (!words[i].trim().isEmpty()){
        buffer
            .append(words[i])
            .append(" ");
      }
    }
    return buffer.toString().trim();                //去掉最后一次多追加的空格
  }

}
