package grammar.exception.sample;

import org.testng.annotations.Test;

/**
 * {@link java.lang.InstantiationException} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 12:03
 */
public class InstantiationExceptionTest {

  @Test(description = "注解无法实例化 java.lang.InstantiationException: org.testng.annotations.Test")
  public void testInstantiationException() throws IllegalAccessException, InstantiationException {
    Test calendar = Test.class.newInstance();
  }

}
