package com.liyun.qa.edu.java.api.juc.class_thread;

import java.util.concurrent.*;

/**
 *
 *
 * @date 2020/9/10 0:25
 */
public class FutureGetException {

  public static void main(String[] args) {
    ExecutorService service = Executors.newFixedThreadPool(20);
    Future<Integer> future = service.submit(new CallableTask());

    try {
      for (int i = 0; i < 5; i++) {
        System.out.println(i);
        Thread.sleep(500);
      }
      System.out.println(future.isDone());
      future.get();     //抛出异常
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }


  static class CallableTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
      throw new IllegalArgumentException("Callable抛出异常");
    }
  }
}

