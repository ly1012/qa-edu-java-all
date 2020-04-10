package exception;

import org.testng.annotations.Test;

import javax.print.PrintException;

/**
 * 受检查异常，程序必须处理，否则编译不通过。
 *
 * @author Li Yun
 * @date 2020/4/9 18:49
 */
public class CheckedExceptionTest {

  @Test(description = "受检查异常，程序必须处理，否则编译无法通过")
  public void testCatchCheckedException() {
    try {
      throw new PrintException("我不想打印");
    } catch (PrintException e) {
      System.out.println("打印中...");
    }
  }

}
