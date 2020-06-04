package leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutePalindromeTest {

  @Test(description = "算法1：哈希表，成对消除", dataProvider = "tc_testCanPermutePalindrome")
  public void testCanPermutePalindrome(String s, boolean expected) {
    assertThat(PermutePalindrome.canPermutePalindrome(s)).isEqualTo(expected);
  }

  @Test(description = "算法2：哈希表，计数", dataProvider = "tc_testCanPermutePalindrome")
  public void testCanPermutePalindrome2(String s, boolean expected) {
    assertThat(PermutePalindrome.canPermutePalindrome2(s)).isEqualTo(expected);
  }

  @Test(description = "算法3：哈希表（数组实现），计数", dataProvider = "tc_testCanPermutePalindrome")
  public void testCanPermutePalindrome3(String s, boolean expected) {
    for (char c : s.toCharArray()){       //包含非 ASCII 字符的字符串，跳过测试
      if (!(c >= 0 && c <= 127)) return;
    }
    assertThat(PermutePalindrome.canPermutePalindrome3(s)).isEqualTo(expected);
  }

  @DataProvider(name = "tc_testCanPermutePalindrome")
  public Object[][] dataprovider() {
    return new Object[][]{
        {"tactcoa", true},
        {"tatasu", false},
        {"", true},
        {"t", true},
        {"at", false},
        {"abab", true},
        {"我们我", true}
    };
  }

}