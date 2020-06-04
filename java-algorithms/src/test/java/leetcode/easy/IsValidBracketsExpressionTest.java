package leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsValidBracketsExpressionTest {

  @Test(description = "有效的括号，算法1：左括号入栈", dataProvider = "testcase")
  public void testIsValid(String input, boolean expected) {
    boolean actual = IsValidBracketsExpression.isValid(input);
    assertThat(actual).isEqualTo(expected);
  }

  @Test(description = "有效的括号，算法2：右括号入栈", dataProvider = "testcase")
  public void testIsValid2(String input, boolean expected) {
    boolean actual = IsValidBracketsExpression.isValid2(input);
    assertThat(actual).isEqualTo(expected);
  }

  @Test(description = "有效的括号，算法3：数组模拟栈，右括号入栈", dataProvider = "testcase")
  public void testIsValid3(String input, boolean expected) {
    boolean actual = IsValidBracketsExpression.isValid3(input);
    assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "testcase")
  public Object[][] testcase() {
    return new Object[][]{
        {"", true},                       //空字符串
        {"()", true},                     //一对括号
        {"()[]{}", true},                 //多对括号，依次排列
        {"{[]}", true},                   //多对括号，嵌套排列
        {"{[([()])]}", true},             //多对括号，多层嵌套排列
        {"{[]}()()[]", true},             //多对括号，嵌套排列+依次排列
        {"(]", false},                    //括号不匹配
        {"][", false},                    //括号顺序不对，右括号在前
        {"([)]", false},                  //括号顺序不对，没有成对依次闭合
        {"((())", false},                 //括号没有成对
        {"[[[((({{{", false},             //全部是左括号
        {"))]]]}", false}                 //全部是右括号
    };
  }

}