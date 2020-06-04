package exception;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 执行顺序测试
 *
 * @author Li Yun
 * @date 2020/4/9 18:53
 */
public class ExceptionExecuteSequenceTest {

  @Test(description = "常见结构，测试执行顺序")
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

  @Test(description = "try 后面接多个 catch 块")
  public void testTryMultiCatch() {
    try {
      System.out.println("try");
      List<String> list =  Files.readAllLines(Paths.get("xxx"));
      System.out.println(list);
    }catch (FileNotFoundException fileNotFoundException){
      System.out.println("FileNotFoundException");
    }catch (IOException exception){
      System.out.println("IOException");
    }
  }

  @Test(description = "try 如果没有 catch 块，则必须跟一个 finally 块。")
  public void testTryFinally() {
    try {
      System.out.println("try");
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

  @Test(description = "测试 Catch 和 Finally 都抛出异常的情况")
  public void testException() {
    try{
      System.out.println("try-in");
      throw new FaimlyException("吵架了");
    }catch (FaimlyException exception){
      System.out.println("catch-in");
      throw new RuntimeException("Catch 解决不了");
    }finally {
      System.out.println("finally-in");
      throw new RuntimeException("Finally 异常");   //和 return 类似，这里的异常覆盖了 catch 中的异常，最终抛出此异常
    }
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
