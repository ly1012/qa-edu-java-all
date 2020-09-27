package com.liyun.qa.edu.java.api.juc.lock_free.cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampedReference 类可以解决 ABA 问题。
 *
 * 本线程读取时为 A + timestamp，如果中间被其他线程更新并改回 A，则是 A + timestamp_n，否则还是 A + timestamp。
 * 即如果中途被其他线程修改，则 timestamp 将不再相等。
 *
 * 本示例不是很恰当，仅是为了解释增加 timestamp 可以解决 ABA 问题的原理。
 *
 * 1、当使用 money.compareAndSet(expectValue, newValue, timestamp, timestamp +1) 时：
 * 注：充值线程先执行，消费线程后执行。如果消费线程先执行，timestamp 增加，那充值线程永远也不会比较成功。
 * （1）每更新一次，timestamp 加 1。
 * （2）充值线程的 timestamp 值，在实例化线程时，就已确定且不可修改，因此只有一个线程可以更新成功（充值成功）。
 * （3）消费线程的 timestamp 值，是每次尝试更新前动态获取的。
 * （4）程序会先充值一次，然后消费几次，直到余额不足。
 *
 * 2、当使用 money.compareAndSet(expectValue, newValue, timestamp, timestamp) 时：
 * （1）将退化成普通的 CAS 算法，即等价于没有 timestamp，因为 timestamp 的值一直没有改变过，timestamp 的比较恒成立。
 * （2）程序会不断的消费、充值。
 *
 * @author Li Yun
 * @date 2020/9/2 16:01
 */
public class AtomicStampedReferenceTest {

  static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19,0);

  public static void main(String[] args) {
    //模拟多个线程同时更新后台数据库，为用户充值
    for (int i = 0; i < 3; i++){
        final int timestamp = money.getStamp();
        final int finalI = i;
      new Thread(){
          @Override
          public void run() {
            //try {
            //  Thread.sleep(300);
            //} catch (InterruptedException e) {
            //  e.printStackTrace();
            //}
            while (true){
              while (true){
                Integer m = money.getReference();
                if (m < 20){
                  //System.out.println("[Admin"+ finalI +"]预期值："+ m);
                  if (money.compareAndSet(m, m + 20, timestamp, timestamp +1)){
                    System.out.println("[Admin"+ finalI +"]余额小于20元，充值20元成功，当前余额："
                                        + money.getReference() + "元");
                    break;
                  }
                }else {
                  //System.out.println("[Admin"+ finalI +"]余额大于20元，无需充值");
                  break;
                }
              }
            }
          }
        }.start();
    }

    new Thread(){
      @Override
      public void run() {
        for (int i = 0; i < 100; i++){
          while (true){
            int timestamp = money.getStamp();
            Integer m = money.getReference();
            if(m > 10){
              System.out.println("[User]大于10元");
              if (money.compareAndSet(m, m -10, timestamp, timestamp +1)){
                System.out.println("[User]成功消费10元，当前余额："+ (m-10));
                break;
              }
            }else {
              //System.out.println("[User]没有足够的余额（小于等于10元）可以消费");
              break;
            }
          }
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();
  }

}
