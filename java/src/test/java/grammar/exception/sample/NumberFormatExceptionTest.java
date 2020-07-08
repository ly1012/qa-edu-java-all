package grammar.exception.sample;

import org.testng.annotations.Test;

/**
 * {@link java.lang.NumberFormatException} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 10:47
 */
public class NumberFormatExceptionTest {

  @Test
  public void testNumberFormatException() {
    int a = Integer.valueOf("12-3");
  }

}
