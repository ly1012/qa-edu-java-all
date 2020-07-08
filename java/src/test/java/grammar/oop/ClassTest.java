package grammar.oop;

import concurrent.synchronizedkey.MultiPrint;
import concurrent.synchronizedkey.PrintSync;
import org.testng.annotations.Test;

/**
 * Class 测试
 *
 * @author Li Yun
 * @date 2020/4/7 15:39
 */
public class ClassTest {

  @Test(description = "一个类的 class 只有一个")
  public void testClass() {
    Class clazz = PrintSync.class;
    System.out.println(clazz.hashCode());
    Class clazz2 = PrintSync.class;
    System.out.println(clazz2.hashCode());
    Class clazz3 = new PrintSync().getClass();
    System.out.println(clazz3.hashCode());
    Class clazz4 = new PrintSync().getClass();
    System.out.println(clazz4.hashCode());
    Class clazz5 = MultiPrint.class;
    System.out.println(clazz5.hashCode());
  }

}
