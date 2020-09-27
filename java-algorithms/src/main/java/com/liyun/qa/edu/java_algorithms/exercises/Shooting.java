package com.liyun.qa.edu.java_algorithms.exercises;

import java.util.Arrays;
import java.util.concurrent.atomic.LongAdder;

/**
 * <b>递归算法</b>
 * <p>题目：一个射击运动员打靶，靶一共有 10 环，连开 10 枪打中 90 环的可能性有多少种？</p>
 *
 * @author Li Yun
 * @date 2020/4/8 14:21
 */
public class Shooting {

  /**
   * 计算所有可能的排列数
   * @param times 总射击次数
   * @param totalScore 预期总环数
   * @return 所有可能排列数
   */
  public static long shoot(int times, int totalScore){
    if (times <=0 || totalScore < 0 || totalScore > times*10){
      return 0L;
    }
    //scores 数组表示一个射击的排列结果，scores[i] 表示第 i 枪的环数
    int [] scores = new int[times];
    Arrays.fill(scores, 0);
    LongAdder count = new LongAdder();
    shoot(times, times, totalScore, scores, count);
    return count.longValue();
  }

  /**
   * 计算所有可能的排列数
   * @param times 总射击次数
   * @param leftTimes 剩余射击次数
   * @param totalScore 剩余总环数
   * @param scores 记录成绩的数组
   * @param count 计数器，统计所有可能的排列数
   */
  private static void shoot(int times, int leftTimes, int totalScore, int[] scores,LongAdder count) {
    if(leftTimes == 1 ) { //递推基础
      //如果最后一次射击时，剩余总环数不在这个范围，说明对应的排列不符合要求，不纳入统计。
      //应该和前面一句的分支合并，这里这么写为了方便理解。
      if (totalScore <= 10 && totalScore >= 0){
        scores[times - leftTimes] = totalScore; //最后一次射击的环数
        count.increment(); //符合要求的排列，统计数加一
      }
    }

    // 减小搜索空间（如果剩余射击次数每次满分也达不到剩余分数，结束搜索）
    if(totalScore > leftTimes * 10) return;

    if(leftTimes > 1) { //递推关系
      for(int i = 0; i <= 10; i++) {  //这里使用了循环，所以会出现分支（11个）
        scores[times - leftTimes] = i;
        shoot(times, leftTimes - 1, totalScore - i, scores, count);
      }
    }
  }
}
