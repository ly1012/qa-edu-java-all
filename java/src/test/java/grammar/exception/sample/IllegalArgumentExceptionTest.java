package grammar.exception.sample;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

/**
 * {@link java.lang.IllegalArgumentException} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 10:52
 */
public class IllegalArgumentExceptionTest {

  @Test(description = "java.lang.IllegalArgumentException: Cannot format given Object as a Date")
  public void testIllegalArgumentException() {
    SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM");
    String format = dateFormat.format("2020-05");
    System.out.println(format);
  }
}
