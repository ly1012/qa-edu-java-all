package com.liyun.qa.edu.design_pattern.singleton;

/**
 * 饿汉式（线程安全）
 *
 * @author Li Yun
 * @date 2020/9/10 22:44
 */
public class Singleton03 {

  //类加载时初始化，线程安全
  private static Singleton03 instance = new Singleton03();

  private Singleton03() {
  }

  public static Singleton03 getInstance() {
    return instance;
  }

}
