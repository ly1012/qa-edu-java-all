package sort;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortTest {

  @Test(description = "冒泡排序测试", dataProvider = "testcase")
  public void testBubbleSort(int[] actual, int[] expect) {
    Sort.bubbleSort(actual);
    assertThat(actual).isEqualTo(expect);
  }

  @Test(description = "选择排序测试", dataProvider = "testcase")
  public void testSelectionSort(int[] actual, int[] expect) {
    Sort.selectionSort(actual);
    assertThat(actual).isEqualTo(expect);
  }

  @Test(description = "插入排序测试", dataProvider = "testcase")
  public void testInsertionSort(int[] actual, int[] expect) {
    Sort.insertionSort(actual);
    assertThat(actual).isEqualTo(expect);
  }

  @Test(description = "归并排序测试", dataProvider = "testcase")
  public void testMergeSort(int[] actual, int[] expect) {
    MergeSort.mergeSort(actual);
    assertThat(actual).isEqualTo(expect);
  }

  @Test(description = "快速排序测试", dataProvider = "testcase")
  public void testQuickSort(int[] actual, int[] expect) {
    QuickSort.quickSort(actual);
    assertThat(actual).isEqualTo(expect);
  }

  @Test(description = "随机快速排序测试", dataProvider = "testcase")
  public void testRandomQuickSort(int[] actual, int[] expect) {
    RandomQuickSort.randomQuickSort(actual);
    assertThat(actual).isEqualTo(expect);
  }

  @Test(description = "计数排序测试", dataProvider = "testcase")
  public void testCountSort(int[] a, int[] expect) {
    int[] actual = CountSort.countSort(a);
    assertThat(actual).isEqualTo(expect);
  }

  @DataProvider(name = "testcase")
  public Object[][] testcase(){
    return new Object[][]{
        {new int[]{}, new int[]{}},                             //0 个元素
        {new int[]{1}, new int[]{1}},                           //1 个元素
        {new int[]{3,1}, new int[]{1,3}},                       //2 个元素
        {new int[]{6,2,4}, new int[]{2,4,6}},                   //随机排列
        {new int[]{4,2,3,1}, new int[]{1,2,3,4}},               //倒序排列
        {new int[]{1,2,3,4}, new int[]{1,2,3,4}},               //正序排列
        {new int[]{10,9,7,17}, new int[]{7,9,10,17}},           //随机排列
        {new int[]{8,8,8,8}, new int[]{8,8,8,8}},               //数组中元素全部相同
        {new int[]{0,0,0,0}, new int[]{0,0,0,0}},               //数组中元素全部相同
        {new int[]{-8,-8,-8,-8}, new int[]{-8,-8,-8,-8}},       //数组中元素全部相同
        {new int[]{Integer.MAX_VALUE-2, Integer.MAX_VALUE-1, Integer.MAX_VALUE-10, Integer.MAX_VALUE-4},
            new int[]{Integer.MAX_VALUE-10, Integer.MAX_VALUE-4, Integer.MAX_VALUE-2, Integer.MAX_VALUE-1}},
                                                                //临界值测试
        {new int[]{-10,2,-3,0,4}, new int[]{-10,-3,0,2,4}},     //正负数测试
        {new int[]{9,8,7,6,5,4,3,2,1}, new int[]{1,2,3,4,5,6,7,8,9}}  //倒序排列
    };
  }

}