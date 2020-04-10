package collection;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 列表学习
 * <p>参考资料：</p>
 * <ul>
 *   <li>[Java中初始化List的5种方法示例](https://www.jb51.net/article/150596.htm)</li>
 * </ul>
 * @date 2020/3/13 18:17<br>
 * @author Li Yun
 */
public class ListTest {

  @Test(description = "初始化 List")
  public void testInit() {
    //[1] 常规写法 先初始化变量，再调用方法。
    //缺点：使用不方便
    List<String> list1 = new ArrayList<>();
    list1.add("a");
    list1.add("b");

    //[2] 双花括号写法 匿名内部类（外层花括号）+类初始化块（内层花括号）
    //优点：写法简洁，适用范围广
    //缺点：损失一点效率，但可以接受
    List<String> list2 = new ArrayList<String>(){{
      add("a");
      add("b");
    }};

    //[3] Arrays.asList方法
    //优点：写法最简洁
    //缺点：因为 asList 方法返回的是 Arryas 的静态内部类 ArrayList，所以不支持增、删元素
    List<String> list3 = Arrays.asList("a", "b");
    list3.set(1,"dd");
    //list3.add("ee"); //会抛出 java.lang.UnsupportedOperationException
    //list3.remove(1); //会抛出 java.lang.UnsupportedOperationException
    print(list3);

    //[4] Stream (JDK8)
    List list4 = Stream.of("a", "b").collect(Collectors.toList());

    //[5] TestNG 的 Lists 类
    List list5 = Lists.newArrayList("a", "b");

  }

  @Test(description = "测试 add 方法")
  public void testAdd() {
    List list = new ArrayList<String>(){{
      add("0");
      add("1");
      add("2");
      add("3");
    }};
    list.add(2, "4"); //在 2 位置插入 4，原来 2 位置及右边的元素右移
    list.add(2, "5");
    print(list);
  }

  private void print(List list){
    for (Object o : list){
      System.out.println(o);
    }
  }
}
