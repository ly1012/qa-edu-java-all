package com.liyun.qa.edu.design_pattern.singleton;

/**
 * 懒汉式（线程安全、懒加载）
 *
 * @author Li Yun
 * @date 2020/9/10 22:43
 */
public class Singleton02 {

  private static Singleton02 instance;

  private Singleton02() {
  }

  //方法上加 synchronized，对方法整体加锁
  public static synchronized Singleton02 getInstance() {
    if (instance == null) {
      instance = new Singleton02();
    }
    return instance;
  }

}
