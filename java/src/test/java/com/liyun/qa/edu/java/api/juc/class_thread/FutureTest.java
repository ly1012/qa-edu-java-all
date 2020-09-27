package com.liyun.qa.edu.java.api.juc.class_thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 描述：演示 Future 的使用方法
 *
 * @date 2020/9/10 0:20
 */
public class FutureTest {

  public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(10);
    Future<Integer> future = service.submit(new CallableTask());
    try {
      System.out.println(future.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    service.shutdown();
  }

  static class CallableTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
      Thread.sleep(3000);
      return new Random().nextInt();
    }
  }
}

