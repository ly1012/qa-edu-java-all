package com.liyun.qa.edu.java.juc.pool;

import com.liyun.qa.edu.java.juc.SimpleTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors 学习
 *
 * @author Li Yun
 * @date 2020/5/6 10:10
 */
public class UseExecutors {

  public static void main(String[] args) {
    testNewFixedThreadPool();
  }

  public static void testNewFixedThreadPool(){
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    executorService.submit(new SimpleTask("Tom"));
    executorService.submit(new SimpleTask("Mary"));
    executorService.submit(new SimpleTask("Trump"));
    executorService.submit(new SimpleTask("God"));

  }

}
