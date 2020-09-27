package com.liyun.qa.edu.design_pattern.singleton;

/**
 * 懒汉式（线程不安全、懒加载）
 *
 * @author Li Yun
 * @date 2020/9/10 22:41
 */
public class Singleton01 {

  private static Singleton01 instance;

  private Singleton01() {
  }

  public static Singleton01 getInstance() {
    if (instance == null) {
      instance = new Singleton01();
    }
    return instance;
  }

}
