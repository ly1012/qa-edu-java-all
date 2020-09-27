package com.liyun.qa.edu.java_algorithms.leetcode.easy;

/**
 * <a href="https://leetcode-cn.com/problems/reverse-integer/">7. 整数反转</a>
 *
 * @author Li Yun
 * @date 2020/8/15 17:17
 */
public class _7_ReverseInteger {

  /**
   * 字符串解法
   *
   * 1. 数字转字符串，反转字符串
   * 2. 反转后的字符串转数字，并判断是否溢出
   * @param x
   * @return
   */
  public int reverse(int x) {
    String s = String.valueOf(x);
    char[] chars = s.toCharArray();
    int start = chars[0] == '-' ? 1 : 0;  //反转左边位置
    int end = chars.length - 1;           //反转右边位置
    while (start < end){                  //从两侧开始反转
      char t = chars[start];
      chars[start++] = chars[end];
      chars[end--] = t;
    }
    String resultsStr = String.valueOf(chars);
    int result;
    try{
      result = Integer.parseInt(resultsStr);
    }catch (NumberFormatException e){     //整数溢出返回 0
      result = 0;
    }
    return result;
  }


  /**
   * 数学解法（推荐）
   *
   * 1. 弹出数字：
   * （1）弹出个位数： pop = x % 10
   * （2）弹出个位数前面的数（为下次弹出做准备）：x = x / 10
   * 2. 推入数字（rev 初始值为 0）：
   * （1）tmp = rev * 10 + pop                    //这步可能溢出
   * （2）rev = tmp
   * 3. 推入前进行溢出检查：
   * (1)当 x 为正整数时（反转后的 rev 也是正整数）：
   *    当 rev * 10 + pop > max 时溢出，即 rev >= max / 10（分类推导可得出，这里的 / 是整除），具体来说
   *        rev > max / 10，一定是溢出的。
   *        rev = max / 10，当 pop > max 个位数时溢出。
   * (2)当 x 为负整数时（反转后的 rev 和 pop 也是负整数）：
   *     当 rev * 10 + pop < min 时溢出，即 rev <= min / 10（分类推导可得出，这里的 / 是整除），具体来说
   *        rev < min / 10，一定是溢出的。
   *        rev = min / 10，当 pop < min 个位数时溢出。
   *
   * 以 x 为正整数为例，上面是根据分类推导得出的结论，即根据 rev 与 max / 10 的大小关系。
   * 还有一种更严格、更直观的推导方法：rev * 10 + pop - max > 0，可以看成一个二元一次不等式。
   * 记 rev 为 x，pop 为 y，max 为常量 c，则有二元一次不等式组：
   * {
   *    10x + y - c > 0,
   *    0 <= y <= 9,
   *    x,y ∈ 正整数,
   *    c 是正整数常量
   * }
   * 根据上面的二元一次不等式组，在平面直角坐标系中作图，可以得出不等式组的解集，
   * 再根据 x(rev) 和 y(pop) 是整数得出和分类推导同样的结论。
   *
   * 4. 最大值最小值的个位数推导：这里只讲最简单的找规律方法。
   * 严格证明参考 [77 的 88 次方的末位数字是多少？](https://www.zhihu.com/question/376080887)。
   *
   * 32 位有符号最大值为 2^31-1（一共 32 位，第一位是 ? * 2^31，个位是 ? * 2^0，因为第一位是符号位，所以最大值是 1*2^31-1）
   * 2^1 = 2, 2^2 = 4, 2^3 = 8, 2^4 = 16,
   * 2^5 = 32, 2^6 = 64, ...
   * 因为 31 / 4 = 7...3，所以个位数为 2^3 = 8，即最大值的个位数为 8-1 = 7。
   * 同理，最小值是 -2^31，所以个位数为 8。
   *
   * @param x
   * @return
   */
  public int reverse2(int x){
    int maxPrefix = Integer.MAX_VALUE / 10;     //正整数最大值的前 N-1 位
    int minPrefix = Integer.MIN_VALUE / 10;     //负整数最小是的前 N-1 位
    int rev = 0;                                //反转后的数字
    while(x != 0 ){                             //每次截断最后一位，直到全部截断完
      int pop = x % 10;       //出栈
      x = x / 10;             //出栈
      if (rev > maxPrefix || (rev == maxPrefix && pop > 7)) return 0;     //正整数溢出检查
      if (rev < minPrefix || (rev == minPrefix && pop < -8)) return 0;    //负整数溢出检查
      rev = rev * 10 + pop;   //入栈
    }
    return rev;
  }

}
