package com.liyun.qa.edu.java.api.juc.lock_free.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link java.util.concurrent.atomic.AtomicInteger}
 *
 * @author Li Yun
 * @date 2020/9/2 19:38
 */
public class AtomicIntegerTest {

  static AtomicInteger cnt = new AtomicInteger(0);
  static int cnt_unsafe = 0;

  public static void main(String[] args) throws InterruptedException {
    //新建线程
    int n = 10;
    Thread[] threads = new Thread[n];
    for (int i = 0; i < n; i++) {
      threads[i] = new Thread(){
        @Override
        public void run() {
          for (int j = 0; j < 10000; j++) {
            cnt.incrementAndGet();
            cnt_unsafe++;
          }
        }
      };
    }

    //启动线程
    for (int i = 0; i < n; i++) {
      threads[i].start();
    }

    //等待线程结束
    for (int i = 0; i < n; i++) {
      threads[i].join();
    }

    System.out.println("AtomicInteger: " + cnt);
    System.out.println("int: " + cnt_unsafe);
  }
}
