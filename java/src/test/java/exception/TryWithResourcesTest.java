package exception;

import org.testng.annotations.Test;

import java.io.*;
import java.sql.SQLException;

/**
 * try-with-resources 测试
 *
 * 1. try() 中的资源类需要实现 {@link AutoCloseable} 接口，编译时生成调用 close() 方法的代码
 * 2. try() 中的变量隐式声明为 final，如果在 try 块中修改变量引用，将导致之前引用的资源无法关闭
 * 3. try() 中可以有多个资源，多个资源用 ; 隔开
 *
 * try-with-resources 异常：
 *
 * 1. 将第一个抛出的异常作为最终异常（可能是工作区异常，也可能是 close() 抛出的异常）
 * 2. 在外层的 catch 块中，将 close() 抛出的异常（如果有）作为被抑制异常加入最终异常的被抑制异常列表。
 *
 * @author Li Yun
 * @date 2020/5/21 10:03
 */
public class TryWithResourcesTest {

  @Test(description = "测试多个资源")
  public void testMultiResources() {
    try(FileReader reader = new FileReader(new File("src/test/resources/test.txt"));
        BufferedReader bufferedReader = new BufferedReader(reader)){

      //reader = new FileReader(new File(""));              //注意 try-with-resources 中，try() 中变量隐式声明为 final
      System.out.println(bufferedReader.readLine());

    } catch (FileNotFoundException fileNotFoundException) { //如果第一个资源创建失败，捕获该异常，
                                                            //此时两个资源都为 null ，不需要关闭资源
      fileNotFoundException.printStackTrace();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }


  @Test(description = "测试自定义资源，try 块不抛出异常")
  public void testCustomResources() {
    try(MyResources myResources = new MyResources()){
      myResources.workNormal();
    } catch (Exception e) {                                 //捕获 close() 方法可能抛出的异常
      System.out.println("catch-in");
      e.printStackTrace();
    }
  }

  @Test(description = "测试自定义资源，try 块抛出受查异常")
  public void testCustomResourcesWithCheckException() {
    try(MyResources myResources = new MyResources()){
      myResources.workThrowCheckException();
    } catch (SQLException e) {                      //工作区异常为最终异常
      System.out.println("catch-in");
      e.printStackTrace();
    } catch (Exception e) {                         //close() 方法抛出的异常为最终异常
      System.out.println("catch-in 2");
      e.printStackTrace();
    }
  }

  @Test(description = "测试自定义资源，try 块抛出非受查异常")
  public void testCustomResourcesWithUnCheckException() {
    try(MyResources myResources = new MyResources()){
      myResources.workThrowUncheckException();
    } catch (Exception e) {                       //捕获最终异常，可能是工作区异常，也可能是 close() 方法异常
                                                  //本测试场景中为工作区异常，close() 方法异常加入被抑制异常列表
      e.printStackTrace();
    }
  }

  /**
   * 自定义资源类
   */
  class MyResources implements AutoCloseable{

    /**
     * 正常工作，不抛出任何异常
     */
    public void workNormal(){
      System.out.println("workNormal");
    }

    /**
     * 工作异常，抛出受查异常
     * @throws Exception 受查异常
     */
    public void workThrowCheckException() throws SQLException {
      System.out.println("workThrowCheckException");
      throw new SQLException("workThrowCheckException");
    }

    /**
     * 工作异常，抛出非受查异常
     */
    public void workThrowUncheckException(){
      System.out.println("workThrowUncheckException");
      throw new RuntimeException("workThrowUncheckException");
    }

    @Override
    public void close() throws Exception {
      throw new Exception("MyResources 关闭出错");
    }
  }

}
