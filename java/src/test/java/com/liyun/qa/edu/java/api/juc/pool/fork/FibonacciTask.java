package com.liyun.qa.edu.java.api.juc.pool.fork;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 菲波那切数列，后一项的结果等于前两项的和，第 0 项是 0，第 1 项是 1，那么第 2 项就是 0+1=1，以此类推。
 *
 * 代码出处：
 * [拉勾教育 - Java 并发编程 78 讲](https://kaiwu.lagou.com/course/courseInfo.htm?courseId=16#/detail/pc?id=250)
 */
public class FibonacciTask extends RecursiveTask<Integer> {

  int n;

  public FibonacciTask(int n) {
    this.n = n;
  }

  @Override
  public Integer compute() {
    if (n <= 1) {
      return n;
    }
    FibonacciTask f1 = new FibonacciTask(n - 1);
    f1.fork();
    FibonacciTask f2 = new FibonacciTask(n - 2);
    f2.fork();
    return f1.join() + f2.join();
  }

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    for (int i = 0; i < 10; i++) { 
        ForkJoinTask task = forkJoinPool.submit(new FibonacciTask(i));
        System.out.println(task.get());
    }

 }

}