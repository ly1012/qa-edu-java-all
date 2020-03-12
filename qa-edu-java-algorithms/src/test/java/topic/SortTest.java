package topic;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class SortTest {

  @Test(dataProvider = "testcase")
  public void testBubbleSort(int[] actual, int[] expect) {
    Sort.bubbleSort(actual);
    assertEquals(actual, expect);
  }

  @DataProvider(name = "testcase")
  public Object[][] testcase(){
    return new Object[][]{
        {new int[]{}, new int[]{}},
        {new int[]{1}, new int[]{1}},
        {new int[]{3,1}, new int[]{1,3}},
        {new int[]{6,2,4}, new int[]{2,4,6}},
        {new int[]{4,2,3,1}, new int[]{1,2,3,4}},
        {new int[]{1,2,3,4}, new int[]{1,2,3,4}},
        {new int[]{9,8,7,6,5,4,3,2,1}, new int[]{1,2,3,4,5,6,7,8,9}}
    };
  }

  // 实际值数组和预期值数组相等断言
  private void assertEquals(int[] actual, int[] expect){
    Assert.assertTrue(actual.length == expect.length, "实际数组长度和预期数组长度不一致");
    for (int i = 0; i < actual.length; i++){
      Assert.assertEquals(actual[i], expect[i]);
    }
  }

}