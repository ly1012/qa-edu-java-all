package com.liyun.qa.edu.java_algorithms.leetcode.easy;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author Li Yun
 * @date 2020/8/17 14:42
 */
public class _121_BestTimeToBuyAndSellStock {

  /**
   * 暴力循环，以买入时机为基准
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    for(int i = 0; i < prices.length - 1; i++){     //买入
      int max = prices[i+1];                        //求解后续数组的最大值
      for(int j = i+1; j < prices.length; j++){     //卖出，找出最大值卖出
        max = max > prices[j] ? max : prices[j];
      }
      maxProfit = maxProfit > max - prices[i] ? maxProfit : max - prices[i];  //和之前的最大值比较
    }
    return maxProfit;
  }

  /**
   * 一次遍历，以卖出时机为基准
   * @param prices
   * @return
   */
  public int maxProfit2(int[] prices) {
    if (prices.length == 0) return 0;
    int maxProfit = 0;
    int buy = prices[0];        //历史最低点
    for(int i = 1; i < prices.length; i++){     //卖出
      //比较当前最大收益与历史最大收益
      maxProfit = maxProfit > prices[i] - buy ? maxProfit : prices[i] - buy;
      //求解历史最低点的值
      buy = buy < prices[i] ? buy : prices[i];
    }
    return maxProfit;
  }

  /**
   * 一次遍历，以卖出时机为基准（代码优化版）
   * @param prices
   * @return
   */
  public int maxProfit3(int prices[]) {
    int minprice = Integer.MAX_VALUE;             //历史最低点
    int maxprofit = 0;                            //历史最大收益
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minprice)                   //如果小于历史最低点，则当前值为历史最低，肯定不是卖出时机
        minprice = prices[i];
      else if (prices[i] - minprice > maxprofit)  //如果不是历史最低点，是卖出时机，并比较当前收益和历史最大收益
        maxprofit = prices[i] - minprice;
    }
    return maxprofit;
  }

}
