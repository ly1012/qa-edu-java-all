package leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IsFlipedStringTest {

  @Test(description = "字符串轮转判断", dataProvider = "testIsFlipedString")
  public void testIsFlipedString(String s1, String s2, boolean expected) {
    boolean actual = IsFlipedString.isFlipedString(s1, s2);
    assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "testIsFlipedString")
  public Object[][] dataprovider(){
    return new Object[][]{
        {"aa", "aba", false},
        {"waterbottle", "erbottlewat", true},
        {"abcd", "abcd", true},
        {"abcd", "abcp", false}
    };
  }
}