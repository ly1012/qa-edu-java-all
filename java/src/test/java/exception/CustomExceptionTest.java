package exception;

import org.testng.annotations.Test;

/**
 * 自定义异常测试
 *
 * @author Li Yun
 * @date 2020/4/9 18:54
 */
public class CustomExceptionTest {

  @Test
  public void testCustomException() {
    try {
      throw new FaimlyException("丈夫酗酒");
    } catch (FaimlyException e) {
      System.out.println("问题已解决");
    }
  }

}
