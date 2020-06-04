package exception.sample;

import org.testng.annotations.Test;

/**
 * {@link java.lang.CloneNotSupportedException} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 15:32
 */
public class CloneNotSupportedExceptionTest {

  @Test(description = "没有实现 Cloneable 接口：java.lang.CloneNotSupportedException: exception.sample.CloneNotSupportedExceptionTest")
  public void testCloneNotSupportedException() throws CloneNotSupportedException {
      super.clone();
  }

}

