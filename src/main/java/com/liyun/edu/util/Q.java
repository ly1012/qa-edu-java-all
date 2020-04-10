package com.liyun.edu.util;

/**
 * 工具类
 *
 * @author Li Yun
 * @date 2020/4/10 13:47
 */
public class Q {

  /**
   * 当前线程等待一段时间
   * @param millis 等待 millis 毫秒
   */
  public static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
