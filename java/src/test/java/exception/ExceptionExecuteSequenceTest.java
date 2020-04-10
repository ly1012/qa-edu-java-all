package exception;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;

/**
 * 执行顺序测试
 *
 * @author Li Yun
 * @date 2020/4/9 18:53
 */
public class ExceptionExecuteSequenceTest {

  @Test(description = "测试执行顺序")
  public void testSequence() {
    InputStream is = null;
    try {
      System.out.println("try-start");
      read();
      System.out.println("try-end");
    } catch (IOException e3) {
      System.out.println("catch");
    } finally {
      System.out.println("finally");
    }
  }

  @Test(description = "测试执行顺序，Try 含 Return 语句")
  public void testSequenceWithReturnInTry() {
    readWithReturnInTry();
  }

  @Test(description = "测试执行顺序，Catch 含 Return 语句")
  public void testSequenceWithReturnInCatch() {
    readWithReturnInCatch();
  }

  @Test(description = "测试执行顺序，Finally 含 Return 语句")
  public void testSequenceWithReturnInFinally() {
    int actual = readWithReturnInFinally();
    Assert.assertEquals(actual, 0);
  }

  private void read() throws IOException {
    throw new IOException();
  }

  public int readWithReturnInTry(){
    try{
      System.out.println("try-start");
      return 0;
    }catch (Exception e){
      System.out.println("catch");
    }finally {
      System.out.println("finally");  //return 之前执行 finally
    }
    return 0;
  }

  public int readWithReturnInCatch(){
    try{
      System.out.println("try-start");
      throw new IOException();
    }catch (Exception e){
      System.out.println("catch");
      return 0;
    }finally {
      System.out.println("finally");  //return 之前执行 finally
    }
  }

  public int readWithReturnInFinally(){
    try{
      System.out.println("try-start");
      return 4;
    }catch (Exception e){
      System.out.println("catch");
    }finally {
      System.out.println("finally");
      return 0; //最终返回值是 0，这里的 return 值覆盖了 try 中的 return 值
    }
  }

}
