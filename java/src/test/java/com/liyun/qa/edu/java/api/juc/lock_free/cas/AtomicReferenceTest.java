package com.liyun.qa.edu.java.api.juc.lock_free.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * {@link java.util.concurrent.atomic.AtomicReference}
 *
 * 本示例中有两项测试：
 * 1、测试 String 的多次更新，最终结果正确。
 * 2、测试 String 的一次更新，有且仅有一个线程更新成功，其余线程都更新失败。
 *
 * @author Li Yun
 * @date 2020/9/2 19:54
 */
public class AtomicReferenceTest {

  static AtomicReference<String> var = new AtomicReference<>("");
  static AtomicReference<String> var2 = new AtomicReference<>("aaa");
  static String var_unsafe = "";

  public static void main(String[] args) throws InterruptedException {
    //新建线程
    int n = 10;
    Thread[] threads = new Thread[n];

    for (int i = 0; i < n; i++) {
      final int num = i;
      threads[i] = new Thread(() -> {

        for (int j = 0; j < 1000; j++) {
          //测试1：测试多次更新，因为 AtomicReference 是线程安全的，所以最终结果正确
          var.getAndUpdate(oldReference -> oldReference + "a");
          //测试1：测试多次更新，非线程安全，所以最终结果错误
          var_unsafe = var_unsafe + "a";
        }

        //测试2：每个线程随机等待 [0,100) ms，防止测试时总是第一个线程成功
        try {
          Thread.sleep((int) (Math.random()*100));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        //测试2：有且仅有一个线程更新成功，其余线程均更新失败
        if (var2.compareAndSet("aaa", "bbb")){
          System.out.format("Thread[%d] Change var2 success !!!\n", num);
        }else {
          System.out.format("Thread[%d] Change var2 fail\n", num);
        }

      });
    }

    //启动线程
    for (int i = 0; i < n; i++) {
      threads[i].start();
    }

    //等待线程结束
    for (int i = 0; i < n; i++) {
      threads[i].join();
    }

    //测试1：查看变量最终结果
    System.out.println("AtomicReference: " + var.get().length());
    System.out.println("String: " + var_unsafe.length());
  }

}
