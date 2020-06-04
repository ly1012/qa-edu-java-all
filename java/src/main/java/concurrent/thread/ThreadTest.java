package concurrent.thread;

/**
 * {@link java.lang.Thread} 测试
 *
 * @author Li Yun
 * @date 2020/5/12 16:28
 */
public class ThreadTest {

  public static void main(String[] args) {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    System.out.println(stackTraceElements[0]);
    System.out.println(stackTraceElements[1]);
  }

}
