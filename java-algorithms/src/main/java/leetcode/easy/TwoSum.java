package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/two-sum/">1. 两数之和</a>
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author Li Yun
 * @date 2020/5/20 23:58
 */
public class TwoSum {

  /**
   * 两数之和
   * <p>
   * 思路：
   * 1. 先固定一个数，再找另一个符合目标的数（second = target - first）
   * 2. 双层循环，暴力破解查找第二个数
   *
   * @param nums   整型数组
   * @param target 目标值
   * @return 符合要求的数对下标
   */
  public static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {           //固定第一个数
      for (int j = i + 1; j < nums.length; j++) {     //在剩余部分查找第二个数
        if (nums[j] == target - nums[i]) {
          return new int[]{i, j};
        }
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  /**
   * 两数之和
   * <p>
   * 思路：
   * 1. 先固定一个数，再找另一个符合目标的数（second = target - first）
   * 2. 两遍哈希查找第二个数，值为 key，下标为 value
   *
   * @param nums   整型数组
   * @param target 目标值
   * @return 符合要求的数对下标
   */
  public static int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {                 //第一遍哈希，key 为元素的值，value 为元素下标
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {                 //第二遍哈希，固定第一个数，从哈希表中查找第二个数
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[]{i, map.get(complement)};
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  /**
   * 两数之和
   * <p>
   * 思路：
   * 1. 先固定一个数，再找另一个符合目标的数（second = target - first）
   * 2. 一遍哈希查找第二个数，值为 key，下标为 value
   *
   * @param nums   整型数组
   * @param target 目标值
   * @return 符合要求的数对下标
   */
  public static int[] twoSum3(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {           //一遍哈希，固定第一个数
      int complement = target - nums[i];              //要查找的第二个数
      if (map.containsKey(complement)) {              //之前的哈希表中查找第二个数
        return new int[]{map.get(complement), i};     //从之前哈希表中查找，等于是倒着查找，所以 i 放在第二位
      }
      map.put(nums[i], i);                            //没查找到第二个数，将第一个数加入哈希表
    }
    throw new IllegalArgumentException("No two sum solution");
  }


}
