package grammar.oop;

import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * 最高父类 Object
 *
 * @author Li Yun
 * @date 2020/4/9 14:27
 */
public class ObjectTest {

  @Test(description = "可以把任何一种数据类型的变量赋给Object类型的变量。")
  public void testArray() {
    //int 类型
    Object obj_int = 8;
    //int 包装类
    Object obj_integer = new Integer(8);
    //字符串
    Object obj_str = "string";
    //一维数组
    Object obj_arr = new String[]{"a","b","c"};
    //二维数组
    Object obj_arr2 = new String[][]{
        {"a","b","c"},
        {"1","2","3"}
    };
    //普通类
    Object obj_map = new HashMap<String,String>();
  }

}
