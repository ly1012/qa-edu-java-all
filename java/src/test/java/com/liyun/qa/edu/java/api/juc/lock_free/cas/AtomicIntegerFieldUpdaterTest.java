package com.liyun.qa.edu.java.api.juc.lock_free.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * {@link AtomicIntegerFieldUpdater}
 *
 * @author Li Yun
 * @date 2020/9/4 0:06
 */
public class AtomicIntegerFieldUpdaterTest {

  static class Data{
    int id;
    volatile int var;
  }

  static AtomicIntegerFieldUpdater<Data> updater = AtomicIntegerFieldUpdater.newUpdater(Data.class, "var");

  static AtomicInteger var_check = new AtomicInteger(0);

  public static void main(String[] args) throws InterruptedException {
    Data obj = new Data();

    //新建线程
    int n = 8;
    Thread[] threads = new Thread[n];
    for (int i = 0; i < n; i++) {
      threads[i] = new Thread(){
        @Override
        public void run() {
          for (int j = 0; j < 10000; j++) {
            updater.incrementAndGet(obj);
            var_check.incrementAndGet();
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

    System.out.println("AtomicIntegerFieldUpdater: " + updater.get(obj));
    System.out.println("AtomicInteger: " + var_check.get());
  }

}
