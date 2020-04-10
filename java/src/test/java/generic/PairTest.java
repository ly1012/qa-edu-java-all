package generic;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Pair 使用示例 <br>
 * 创建时间：2020/3/8 12:08<br>
 * 作者：李云
 */
public class PairTest {

  @Test(description = "测试泛型的使用")
  public void testGeneric() {
    // 指定泛型的具体类型
    Pair<Employee> buddies = new Pair<>(new Employee("马云",1), new Employee("曾明",2));
    Employee buddy = buddies.getFirst();
    assertEquals(buddy.getName(), "马云");

    // 不指定泛型的具体类型。
    // 泛型擦除时，因为没有限定泛型类型，getFirst 返回类型将使用 Object 替代。
    // 翻译泛型时，因为没有指定泛型类型，编译器不会插入强制类型转换。
    // 使用最高父类 Object，不会报错，但没有什么意义，因为最终使用时还是要强制类型转换成目标类型来使用
    Pair buddies2 = new Pair(new Employee("Tom",25), new Employee("Mary",23));
    Object buddy2 = buddies2.getFirst();
    assertEquals(buddy2.getClass(), Employee.class);

    Pair<Employee> buddies4 = new Pair(new Employee("Tom",25), new Employee("Mary",23));
    Pair buddies5 = buddies4;
    Object buddy5 = buddies5.getFirst();  // 这里不能使用 Employee 作为声明类型
    assertEquals(buddy5.getClass(), Employee.class);
  }

  @Test(description = "测试泛型的使用", expectedExceptions = {ClassCastException.class})
  public void testGeneric2() {
    // 不指定泛型的具体类型。
    // 泛型擦除时，因为没有限定泛型类型，getFirst 返回类型将使用 Object 替代。
    // 翻译泛型时，因为没有指定泛型类型，编译器不会插入强制类型转换。
    // 使用时强制类型转换，因为运行时类型和强制类型不匹配，将抛出类造型异常。
    Pair buddies3 = new Pair(new Employee("Tom",25), new Employee("Mary",23));
    String buddy3 = (String) buddies3.getFirst();
  }

}
