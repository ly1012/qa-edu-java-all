package easy;

import java.util.HashMap;

/**
 * 主要元素：https://leetcode-cn.com/problems/find-majority-element-lcci/ <br>
 * 题目：如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * <blockquote><pre>
 * 示例 1:
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * </pre></blockquote>
 * <blockquote><pre>
 * 示例 2：
 * 输入：[3,2]
 * 输出：-1
 * </pre></blockquote>
 * <blockquote><pre>
 * 示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * </pre></blockquote>
 * 创建时间：2020/3/6 10:19<br>
 * 作者：李云
 */
public class MajorElement {

  /**
   * 思路：统计元素出现的次数，如果出现次数为数组长度整除加一则是主要元素。
   * @param nums 整数数组
   * @return 主要元素
   */
  public static int byStatistics(int[] nums) {
    // 统计信息存储：存储元素及其统计数
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    // 识别主要元素的判定条件
    int r = nums.length / 2 + 1;
    // 遍历数组
    for(int i = 0; i < nums.length; i++){
      int element = nums[i];
      // 获取元素出现次数：未出现过的数，统计数字为 0
      int count = map.getOrDefault(element,0) + 1;
      // 如果是主要元素
      if(count == r) return element;
      map.put(element,count);
    }
    return -1;
  }

  /**
   * 思路：摩尔投票算法(Boyer–Moore majority vote algorithm)，https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
   * @param nums 整数数组
   * @return 主要元素
   */
  public static int byBoyer_MooreMajorityVoteAlgorithm(int[] nums){
    // 定义两个变量，major（选举出的主要元素），cnt（选举出的主要元素的票数）
    int major =0, cnt = 0;

    // 投票选举主要元素
    for (int e : nums){
      if (cnt == 0){  // 如果当前 major 票数为零，选举本次循环的元素为 major
        major = e;
        cnt++;
      }else if(e == major){ // 如果当前元素（即本次循环元素）和 major 相同，投赞成票
        cnt++;
      }else{ // 投反对票
        cnt--;
      }
    }

    // 验证选举出的元素是否是主要元素
    int r = nums.length/2 + 1;
    int count = 0;
    for (int e : nums){
      if (e == major){
        count++;
        if (count == r){
          return major;
        }
      }
    }
    return -1;
  }
}
