package api.collection;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link java.util.HashMap} 测试
 *
 * @author Li Yun
 * @date 2020/5/24 20:14
 */
public class HashMapTest {

  @Test(description = "K/V 都必须是引用类型，因为泛型擦除时，都必须是 Object 或其子类")
  public void testType() {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    map.put(new Integer(1), new Integer(1));
    System.out.println(map);
  }
}
