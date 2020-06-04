package concurrent.synchronizedkey;

/**
 * 测试 synchronized 关键字
 *
 * @author Li Yun
 * @date 2020/4/7 13:26
 */
public class MultiPrint {

  public static void main(String[] args) {
    //静态方法使用 Class 对象的锁（Class clazz = PrintSync.class 对象的内部锁），简称类锁
    //非静态方法使用类实例的内部锁（PrintSync ps = new PrintSync() 对象的内部锁），简称对象锁
    //【同一个锁(clazz)，互斥】两个线程，调用不同的静态方法，线程 2 要等线程 1 释放内部锁
    //testStatic();
    //【同一个锁(ps)，互斥】两个线程，共用一个对象，线程 2 要等线程 1 释放内部锁
    //testNoStatic();
    //【不同的锁(ps1/ps2)，不互斥】两个线程，分别持有对象，线程 2 和 线程 1 不会竞争锁
    //testNoStatic2();
    //【不同的锁(clazz/ps)，不互斥】两个线程，线程 1 通过类调用静态方法并进入等待，线程 2 调用非静态方法
    //testStaticAndNoStatic();
    //【不同的锁(clazz/ps)，不互斥】使用静态字段，线程 1 调用静态方法并进入等待，线程 2 调用非静态方法
    //testStaticAndNoStaticByField();
  }


  public static void testNoStatic(){
    PrintSync printSync = new PrintSync();
    new Thread(() -> printSync.syncNoStaticAndWait()).start();
    sleep(1000);
    new Thread(() -> printSync.syncNoStaticNoWait()).start();
  }

  public static void testNoStatic2(){
    PrintSync printSync = new PrintSync();
    new Thread(() -> printSync.syncNoStaticAndWait()).start();
    sleep(1000);
    PrintSync printSync2 = new PrintSync();
    new Thread(() -> printSync2.syncNoStaticNoWait()).start();
  }

  public static void testStatic(){
    new Thread(() -> PrintSync.syncStaticAndWait()).start();
    sleep(1000);
    new Thread(() -> PrintSync.syncStaticNoWait()).start();
  }

  public static void testStaticAndNoStatic(){
    new Thread(() -> PrintSync.syncStaticAndWait()).start();
    sleep(1000);
    new Thread(() -> new PrintSync().syncNoStaticNoWait()).start();
  }

  public static void testStaticAndNoStaticByField(){
    new Thread(() -> PrintSync.syncStaticAndWait()).start();
    sleep(1000);
    new Thread(() -> StaticField.printSync.syncNoStaticNoWait()).start();
  }

  private static void sleep(int milliseconds){
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
