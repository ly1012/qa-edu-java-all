package grammar.exception.sample;

import org.testng.annotations.Test;

/**
 * {@link java.lang.ArrayIndexOutOfBoundsException} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 10:49
 */
public class ArrayIndexOutOfBoundsExceptionTest {

  @Test
  public void testArrayIndexOutOfBoundsException() {
    String[] s = {"a", "b", "c"};
    System.out.println(s[3]);
  }
}
