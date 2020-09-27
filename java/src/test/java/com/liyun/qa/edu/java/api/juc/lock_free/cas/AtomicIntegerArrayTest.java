package com.liyun.qa.edu.java.api.juc.lock_free.cas;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * {@link AtomicIntegerArray}
 *
 * @author Li Yun
 * @date 2020/9/3 15:46
 */
public class AtomicIntegerArrayTest {

  static AtomicIntegerArray arr = new AtomicIntegerArray(10);
  static int[] arr_unsafe = new int[10];

  public static void main(String[] args) throws InterruptedException {
    //新建线程
    int n = 10;
    Thread[] threads = new Thread[n];
    for (int i = 0; i < n; i++) {
      threads[i] = new Thread(){
        @Override
        public void run() {
          for (int j = 0; j < 10000; j++) {
            arr.getAndIncrement(j % arr.length());
            arr_unsafe[j % arr.length()]++;
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

    System.out.format("AtomicIntegerArray: %s\n", arr);
    System.out.format("int[]: %s\n", Arrays.toString(arr_unsafe));
  }

}
