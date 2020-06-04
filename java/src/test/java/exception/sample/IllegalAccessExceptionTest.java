package exception.sample;

import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.Calendar;

/**
 * {@link java.lang.IllegalAccessException} 测试
 *
 * @author Li Yun
 * @date 2020/5/7 11:12
 */
public class IllegalAccessExceptionTest {

  @Test(description = "java.lang.IllegalAccessException: Class exception.sample.IllegalAccessExceptionTest can not access a member of class exception.sample.AccessDemo with modifiers \"private\"")
  public void testIllegalAccessException() throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
    Class clazz = Class.forName("exception.sample.AccessDemo");
    Field field = clazz.getDeclaredField("name");
    //fields[0].setAccessible(true);  //设置可访问
    field.set(new AccessDemo(), "ss");
  }

  @Test(description = "java.lang.IllegalAccessException: Class exception.sample.IllegalAccessExceptionTest can not access a member of class java.util.Calendar with modifiers \"protected\"")
  public void test2() throws IllegalAccessException, InstantiationException {
    Calendar calendar = Calendar.class.newInstance();
  }
}

class AccessDemo{

  private String name;

}
