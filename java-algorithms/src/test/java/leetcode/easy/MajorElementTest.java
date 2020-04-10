package leetcode.easy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MajorElementTest {

  @Test(dataProvider = "testcase")
  public void testByStatistics(int[] nums,int expected) {
    assertEquals(MajorElement.byStatistics(nums), expected);
  }

  @Test(dataProvider = "testcase")
  public void testByBoyer_MooreMajorityVoteAlgorithm(int[] nums,int expected) {
    assertEquals(MajorElement.byBoyer_MooreMajorityVoteAlgorithm(nums), expected);
  }

  @DataProvider(name = "testcase")
  public Object[][] testcase(){
    return new Object[][]{
        {new int[]{}, -1},
        {new int[]{0}, 0},
        {new int[]{4}, 4},
        {new int[]{-5}, -5},
        {new int[]{3,2}, -1},
        {new int[]{2,3}, -1},
        {new int[]{2,2}, 2},
        {new int[]{1,2,3}, -1},
        {new int[]{1,2,2}, 2},
        {new int[]{2,1,2}, 2},
        {new int[]{2,2,1}, 2},
        {new int[]{1,1,2,2}, -1},
        {new int[]{1,2,1,2}, -1},
        {new int[]{1,2,3,3,3}, 3},
        {new int[]{3,3,3,4,5}, 3},
        {new int[]{1,3,2,3,3}, 3},
        {new int[]{3,1,3,2,3}, 3},
        {new int[]{2,2,1,1,1,2,2}, 2},
        {new int[]{1,2,5,9,5,9,5,5,5}, 5}
    };
  }

}