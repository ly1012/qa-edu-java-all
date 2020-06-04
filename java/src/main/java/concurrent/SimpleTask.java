package concurrent;

/**
 * 一个简单的线程任务
 *
 * @author Li Yun
 * @date 2020/5/6 10:12
 */
public class SimpleTask implements Runnable{

  private String name;

  public SimpleTask(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    pause(3000);
    System.out.println(name + " : " +name.length());
  }

  private void pause(long time){
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
