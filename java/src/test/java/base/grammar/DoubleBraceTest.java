package base.grammar;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 双花括号语法
 *
 * @author Li Yun
 * @date 2020/4/9 16:17
 */
public class DoubleBraceTest {

  @Test(description = "双花括号里直接调用对象的方法，本质上是匿名类 + 类初始化块")
  public void testDoubleBrace() {

    Map map = new HashMap<String,String>(){{
      put("a","abc");
      put("b","BBB");
    }};
    //上面的双花括号写法等价于：
    Map map2 = new AnonymousHashMap();

    System.out.println(map.get("a"));
    System.out.println(map2.get("b"));


  }

  class AnonymousHashMap extends HashMap{

    {
      put("a", "abc");
      put("b","BBB");
    }

  }

}
