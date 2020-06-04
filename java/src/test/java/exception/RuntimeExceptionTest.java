package exception;

import org.testng.annotations.Test;

/**
 * 运行时异常，属于非检查异常。（派生于 Error 类或 RuntimeException 类的所有异常成为非检查异常（unchecked））
 * <p>都是 RuntimeException 类及其子类，如 NullPointerException、IndexOutOfBoundsException。</p>
 * <p>运行时异常的特点：</p>
 * <ul>
 *   <li>非检查异常：编译器不会检查这些异常，程序中可以选择捕获处理，也可以不处理，程序不处理也会编译通过。</li>
 *   <li>一般是由程序逻辑错误引起的，程序应该从逻辑角度尽可能避免这类异常的发生。</li>
 * </ul>
 * @author Li Yun
 * @date 2019/1/9 19:51
 */
public class RuntimeExceptionTest {

  @Test(description = "运行时异常，捕获测试")
  public void testCatchRuntimeException() {
    try{
      throw new RuntimeException("运行时异常，可以被捕获");
    }catch (Exception e){
      System.out.println("捕获到异常");
    }
    System.out.println("I'm here."); //可以到达这里
  }

  @Test(description = "运行时异常，不捕获测试")
  public void testUnCatchRuntimeException() {
    throw new RuntimeException("运行时异常，可以不捕获");  //编译通过，程序不是必须处理运行时异常。
    //System.out.println("I'm here."); //无法到达这里
  }



}
