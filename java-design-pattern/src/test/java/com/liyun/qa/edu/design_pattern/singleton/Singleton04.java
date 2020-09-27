package com.liyun.qa.edu.design_pattern.singleton;

/**
 * 双重检查锁（线程安全、懒加载）
 *
 * @author Li Yun
 * @date 2020/9/10 22:52
 */
public class Singleton04 {

  //保证可见性（防止指令重排序、变量读写的原子性）
  //如果没有 volatile 修饰，com.liyun.qa.edu.design_pattern.singleton = new Singleton() ，不是一个原子操作：
  //1. 给 com.liyun.qa.edu.design_pattern.singleton 分配内存空间；
  //2. 调用 Singleton 的构造函数等，来初始化 com.liyun.qa.edu.design_pattern.singleton；
  //3. 将 com.liyun.qa.edu.design_pattern.singleton 对象指向分配的内存空间（执行完这步 com.liyun.qa.edu.design_pattern.singleton 就不是 null 了）。
  //因为存在指令重排序的优化，最终的执行顺序，可能是 1-3-2，但此时对象还未初始化完成，但第一个检查可以通过。
  private static volatile Singleton04 singleton;

  private Singleton04() {
  }

  public static Singleton04 getSingleton() {
    //如果去掉第一个检查，那么所有线程都会串行执行，效率低下
    if (singleton == null) {
      synchronized (Singleton04.class) {  //这一段可以看成是线程安全的懒汉式（方法加 synchronized）
        //如果去掉第二个检查，当两个线程同时进入临界区：
        //第一个线程创建了一个实例并退出临界区，第二个线程进入临界区会再次创建一个实例。
        if (singleton == null) {
          singleton = new Singleton04();
        }
      }
    }
    return singleton;
  }

}