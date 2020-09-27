package com.liyun.qa.edu.design_pattern.singleton;

/**
 * 静态内部类（线程安全、懒加载）
 *
 * @author Li Yun
 * @date 2020/9/10 23:37
 */
public class Singleton05 {

  //静态内部类，延迟实例的加载，Singleton05 类加载（比如调用类中其他静态方法）时不会初始化 INSTANCE
  private static class SingletonHolder {
    private static final Singleton05 INSTANCE = new Singleton05();
  }

  private Singleton05() {
  }

  public static final Singleton05 getInstance() {
    return SingletonHolder.INSTANCE;
  }

}
