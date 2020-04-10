package concurrent.synchronizedkey;

/**
 * synchronized 关键字测试
 *
 * @author Li Yun
 * @date 2020/4/7 13:17
 */
public class PrintSync {


  public synchronized void syncNoStaticAndWait(){
    System.out.println("非静态同步方法 1 开始，等待 3 秒");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("非静态同步方法 1 结束");
  }

  public synchronized void syncNoStaticNoWait(){
    System.out.println("非静态同步方法 2 开始");
    System.out.println("非静态同步方法 2 结束");
  }

  public static synchronized void syncStaticAndWait(){
    System.out.println("静态同步方法 1 开始，并等待 3 秒");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("静态同步方法 1 结束");
  }

  public static synchronized void syncStaticNoWait(){
    System.out.println("静态同步方法 2 开始");
    System.out.println("静态同步方法 2 结束");
  }

}
