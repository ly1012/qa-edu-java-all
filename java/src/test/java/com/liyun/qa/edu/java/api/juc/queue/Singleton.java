package com.liyun.qa.edu.java.api.juc.queue;

/**
 *
 * @author Li Yun
 * @date 2020/9/10 21:49
 */
public class Singleton {

  private static Singleton instance;

  private Singleton() {
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}
