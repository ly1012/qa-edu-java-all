package grammar.exception.sample;

import org.testng.annotations.Test;

/**
 * {@link java.lang.ClassNotFoundException} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 10:31
 */
public class ClassNotFoundExceptionTest {

  @Test
  public void testClassNotFoundException1() throws ClassNotFoundException {
    Class.forName("a.b.c.ClassA");
  }

  @Test
  public void testClassNotFoundException2() throws ClassNotFoundException {
    this.getClass().getClassLoader().loadClass("a.b.c.ClassA");
  }

}
