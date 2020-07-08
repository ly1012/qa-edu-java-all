package api;

import org.testng.annotations.Test;

/**
 * Runtime 类
 *
 * @author Li Yun
 * @date 2020/4/9 22:53
 */
public class RuntimeTest {

  @Test(description = "测试 addShutdownHook 方法")
  public void testAddShutdownHook() {
    System.out.println("print.");
    Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("虚拟机关闭")));  //虚拟机关闭钩子
    System.out.println("print..");
    throw new Error("程序挂了");
  }

}
