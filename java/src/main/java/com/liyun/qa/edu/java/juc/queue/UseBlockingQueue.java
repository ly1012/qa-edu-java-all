package com.liyun.qa.edu.java.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列
 *
 * @author Li Yun
 * @date 2020/5/5 10:11
 */
public class UseBlockingQueue {

  public static void main(String[] args) {
    testBlockingQueue();
  }

  public static void testBlockingQueue(){
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(10);
    blockingQueue.add("a");
    blockingQueue.add("b");
    blockingQueue.add("c");

    System.out.println(blockingQueue.poll());
    System.out.println(blockingQueue.poll());
    System.out.println(blockingQueue.poll());
    System.out.println(blockingQueue.poll());

    blockingQueue.stream().forEach(s -> System.out.println(s));

  }

}
