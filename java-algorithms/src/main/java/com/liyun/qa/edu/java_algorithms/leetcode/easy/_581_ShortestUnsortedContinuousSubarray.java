package com.liyun.qa.edu.java_algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.Stack;

/**
 * 581. 最短无序连续子数组
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 *
 * @author Li Yun
 * @date 2020/8/17 15:35
 */
public class _581_ShortestUnsortedContinuousSubarray {

  /**
   * 暴力循环：左右消除，直到不能消除，得出最短无序连续子数组长度
   * @param nums
   * @return
   */
  public int findUnsortedSubarray(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    boolean left = false;
    boolean right = false;
    while(low < high && (!left || !right) ){
      if(!left){
        int min = nums[low+1];                //求最小值
        for(int i = low+1; i <= high; i++){
          min = min < nums[i] ? min : nums[i];
        }
        if(nums[low] <= min){                 //如果最左边小于等于数组中的最小值，去掉该元素
          low++;
        }else{
          left = true;
        }
      }else if(!right){
        int max = nums[high-1];                 //求最大值
        for(int i = low; i <= high-1; i++){
          max = max > nums[i] ? max : nums[i];
        }
        if(nums[high] >= max){                  //如果最右边大于等于数组中的最大值，去掉该元素
          high--;
        }else{
          right = true;
        }
      }
    }
    int size = high - low;
    return size == 0 ? 0 : size + 1;
  }

  /**
   * 暴力法优化：选择排序的思想
   * @param nums
   * @return
   */
  public int findUnsortedSubarray2(int[] nums) {
    int l = nums.length;
    int r = 0;
    for (int i = 0; i < nums.length-1 ; i++){
      for (int j = i+1; j < nums.length; j++){
        if (nums[j] < nums[i]){                 //[i, j] 是无序子数组，i 和 j 应该交换。
          l = Math.min(l, i);                   //找出所有无序子数组集合的左边界
          r = Math.max(r, j);                   //找出所有无序子数组集合的右边界
        }
      }
    }
    return r - l < 0 ? 0 : r - l +1;    // r-l 不会等于 0
                                        // 要么初始值为负（题目数组长度不为零），要么为有交换则为正值
  }

  /**
   * 数组排序后和原数组比对，根据相同位置不同值，找出左右边界
   * @param nums
   * @return
   */
  public int findUnsortedSubarray3(int[] nums) {
    int[] snums = nums.clone();     //对原数组排序
    Arrays.sort(snums);
    int start = nums.length;
    int end = 0;
    for (int i = 0; i < nums.length; i++){    //排序后数组和原数组比对
      if (nums[i] != snums[i]){
        start = Math.min(start, i);
        end = Math.max(end, i);
      }
    }
    return end - start < 0 ? 0 : end - start + 1;
  }

  /**
   * 使用栈的回溯特性，找出最短无序子数组最小值和最大值的正确位置（即左右边界）。
   * @param nums
   * @return
   */
  public int findUnsortedSubarray4(int[] nums) {
    int l = nums.length;
    int r = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < nums.length; i++){
      while (!stack.isEmpty()
          && nums[stack.peek()] > nums[i]){   //默认将曲线开始的升序段（从 0 开始）的最后一个元素值下标作为栈顶，注意比较的是元素值。
                                              //如果有元素（记为最小值）小于栈顶元素，查找最小值的正确位置，并将最小值下标推入栈顶，保持栈是连续的升序。
                                              //如果还有元素（新的最小值）小于栈顶元素（原来的最小值），查找新的最小值正确位置，并将新的最小值下标推入栈顶。
        l = Math.min(l, stack.pop());         //弹出非连续升序（这里指截止当前，最小值及值更小的元素）的所有下标，一次只会弹出一个。
      }
      stack.push(i);                          //栈中下标对应的值，永远保持升序，栈顶为栈中的最大值（对应最小值正确下标，即左边界）。
    }
    for (int i = nums.length -1; i >= 0; i--){                    //和最小值正确位置等价，这里栈保持降序，从右往左找。
      while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
        r = Math.max(r, stack.pop());
      }
      stack.push(i);
    }
    return r - l <=0 ? 0 : r - l +1;
  }

  /**
   * 不使用额外空间
   * @param nums
   * @return
   */
  public int findUnsortedSubarray5(int[] nums) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    //boolean flag = false;
    //for (int i = 1; i < nums.length; i++) {         //找出最小值的值，上面的方法4是找最小值的正确位置
    //  if (nums[i] < nums[i - 1])
    //    flag = true;
    //  if (flag){                                    //如果前一个元素是折点，意味着该元素是最小值或新的最小值
    //    min = Math.min(min, nums[i]);
    //    flag = false;
    //  }
    //}
    //flag = false;
    //for (int i = nums.length - 2; i >= 0; i--) {    //找出最大值的值，上面的方法4是找最大值的正确位置
    //  if (nums[i] > nums[i + 1])
    //    flag = true;
    //  if (flag){                                    //如果前一个元素是折点，意味着该元素是最大值或新的最大值
    //    max = Math.max(max, nums[i]);
    //    flag = false;
    //  }
    //}
    //合并上面的代码
    for (int i = 1; i < nums.length; i++){
      if (nums[i-1] > nums[i]){
        max = Math.max(max, nums[i-1]);
        min = Math.min(min, nums[i]);
      }
    }
    int l, r;
    for (l = 0; l < nums.length; l++) {             //找出最小值的正确位置，即左边界
      if (min < nums[l])
        break;
    }
    for (r = nums.length - 1; r >= 0; r--) {        //找出最大值的正确位置，即右边界
      if (max > nums[r])
        break;
    }
    return r - l < 0 ? 0 : r - l + 1;
  }

}
