package leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoSumTest {

  @Test(description = "两数之和，算法1：双层循环，暴力查找", dataProvider = "testcase")
  public void testTwoSum(int[] input, int target, int[] expected) {
    int[] actual = TwoSum.twoSum(input, target);
    assertThat(actual).isEqualTo(expected);
  }

  @Test(description = "两数之和，算法2：两遍哈希，第一遍哈希，第二遍查找", dataProvider = "testcase")
  public void testTwoSum2(int[] input, int target, int[] expected) {
    int[] actual = TwoSum.twoSum2(input, target);
    assertThat(actual).isEqualTo(expected);
  }

  @Test(description = "两数之和，算法3：一遍哈希，哈希和查找同时进行", dataProvider = "testcase")
  public void testTwoSum3(int[] input, int target, int[] expected) {
    int[] actual = TwoSum.twoSum3(input, target);
    assertThat(actual).isEqualTo(expected);
  }

  @DataProvider(name = "testcase")
  public Object[][] testcase(){
    return new Object[][]{
        {new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}},
        {new int[]{2, 2, 3}, 4, new int[]{0, 1}},
        {new int[]{3,2,2,6}, 4, new int[]{1,2}}
    };
  }
}