package grammar.datatype.reference;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TODO
 *
 * @author Li Yun
 * @date 2020/6/3 9:53
 */
public class IntegerTest {

  @Test(description = "拆箱、装箱")
  public void testBoxingAndUnboxing() {
    Integer obj = new Integer(2);

    obj = Integer.valueOf(4);          //装箱：通过装箱方法。注意：装箱方法中对于某个区间数值使用了常量池。

    int a = obj.intValue();            //拆箱：通过拆箱方法
  }

  @Test(description = "自动装箱时机：赋值、传参")
  public void testAutoboxing() {
    //============= 赋值时自动装箱 ==============
    Integer a = 1;
    Integer a2[] = new Integer[]{Integer.valueOf(1), Integer.valueOf(2), 3};

    //============== 传参时自动装箱 =================
    List<Integer> li = new ArrayList<>();
    for (int i = 1; i < 50; i += 2)
      li.add(i);                          //等价于：li.add(Integer.valueOf(i));
  }

  @Test(description = "自动拆箱时机：赋值、运算、字符串连接、传参")
  public void testAutounboxing() {
    //============= 赋值时自动拆箱 ==============
    int n = new Integer(5);    //包装类对象赋值给基本类型变量
    int n2[] = new int[]{1, 2, Integer.valueOf(3)};

    //============= 运算时自动拆箱 ==============
    Integer a = new Integer(1);
    Integer b = new Integer(2);
    int t1 = a + b;                     //加法运算：包装类型 + 包装类型，赋值给基本类型
    Integer t2 = a + b;                 //加法运算：包装类型 + 包装类型，赋值给包装类型
    assertThat(t1).isEqualTo(3);
    assertThat(t2).isEqualTo(3);

    assertThat(new Integer(5) + 1)    //加法运算：包装类型 + 基本类型
        .isEqualTo(6);

    //============== 字符串连接符：+ =================
    assertThat(new Integer(1) + "a")  //字符串连接符：包装类型 + 字符串
        .isEqualTo("1a");

    //============== 传参时自动拆箱 =================
    assertThat(unboxingInParam(new Integer(8)))
        .isEqualTo(11);
  }

  private int unboxingInParam(int a){
    return a + 3;
  }

  @Test(description = "调用重载方法测试：不会自动装箱、拆箱")
  public void testOverload() {
    assertThat(print(1)).isEqualTo("基本数据类型");
    assertThat(print(Integer.valueOf(1))).isEqualTo("包装类");
  }

  public String print(int i){
    return "基本数据类型";
  }

  public String print(Integer i){
    return "包装类";
  }

  @Test(description = "自动拆箱：包装类型值为 null 时将抛出 NPE", expectedExceptions = {NullPointerException.class})
  public void testAutounboxingWithNull() {
    Integer i = null;
    int j = i;
  }

  @Test(description = "自动拆箱、装箱性能：内存、速度")
  public void testAutoboxing2() {
    Integer sum = 0;
    for(int i = 0; i < 100000000; i++) {
      sum += 1;                   //等价于 sum = Integer.valueOf(sum.intValue() + i);
                                  //将会创建大量 Integer 对象
    }
    System.out.println(sum);
  }

  @Test
  public void testCompare() {
    Object a = new Object();
    Object b = new Object();
    System.out.println(a == b);

  }
}
