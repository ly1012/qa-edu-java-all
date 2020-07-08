package grammar.exception.sample;

import org.testng.annotations.Test;

/**
 * {@link java.lang.ArrayStoreException} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 11:54
 */
public class ArrayStoreExceptionTest {

  @Test(description = "java.lang.ArrayStoreException: java.lang.String")
  public void testArrayStoreException() {
    Object[] data = new Integer[3];
    data[0] = "abc";
  }

}
