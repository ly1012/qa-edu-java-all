package com.liyun.qa.edu.java.api.juc.lock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * {@link java.util.concurrent.CyclicBarrier} 循环障栅
 *
 * @author Li Yun
 * @date 2020/9/5 15:58
 */
public class CyclicBarrierTest {

  public static class Soldier implements Runnable{
    
    private String soldier;
    private final CyclicBarrier cyclic;
    
    Soldier(CyclicBarrier cyclic, String soldierName){
      this.cyclic = cyclic;
      this.soldier = soldierName;
    }

    @Override
    public void run() {
      try {
        //第一个集结点（栅栏）：等待所有士兵到齐
        cyclic.await();
        doWork();
        //第二个集结点（栅栏）：等待所有士兵完成工作
        cyclic.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (BrokenBarrierException e) {
        e.printStackTrace();
      }
    }

    void doWork() {
      try {
        Thread.sleep(Math.abs(new Random().nextInt()%10000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(soldier + ":任务完成");
    }


  }

  public static class BarrierRun implements Runnable{

    boolean flag = false;
    int N;

    public BarrierRun( int N){
      this.N = N;
    }

    @Override
    public void run() {
      if (flag){
        System.out.format("司令：[士兵%d个，任务完成！]\n", N);
      }else {
        System.out.format("司令：[士兵%d个，集合完毕！]\n", N);
        flag = true;
      }
    }

    public static void main(String[] args) {
      final int N = 10;
      Thread[] allSoldier = new Thread[N];
      CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(N));
      //CyclicBarrier cyclic = new CyclicBarrier(N/2, new BarrierRun(N));
      //设置屏障点，主要是为了执行这个方法
      System.out.println("集合队伍！");
      for (int i = 0; i < N; i++) {
        System.out.format("士兵%d报道！\n", i);
        allSoldier[i] = new Thread(new Soldier(cyclic, "士兵" + i));
        allSoldier[i].start();
        //if (i == 5){
        //  allSoldier[0].interrupt();
        //}
      }
    }
  }

}
