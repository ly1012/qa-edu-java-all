package com.liyun.qa.edu.java.grammar.FP;

import com.liyun.qa.edu.java.grammar.oop.xinterface.Factory;
import org.testng.annotations.Test;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.Supplier;


public class LambdaTest {

  //测试数据
  String[] data = new String[]{"aa","bbb","c","ddddd"};

  //测试用的示例类
  static class Demo {

    public static int staticM(String a, String b){
      return a.length() > b.length() ? 1 : -1;
    }

    public int instanceM(String a, String b){
      return a.length() > b.length() ? 1 : -1;
    }

    public static <T, DEST extends Collection<T>> DEST transfer(T[] arr, Supplier<DEST> supplier){
      DEST set = supplier.get();
      for (T s : arr) {
        set.add(s);
      }
      return set;
    }
  }

  @Test(description = "方法引用：静态方法")
  public void testMethodReference_static_method() {

    //省略了类声明、方法声明和 return，只保留了方法体。
    //1. 上下文：根据上下文（形参类型）可以推断出类声明为 new MyClass implements Comparator
    //2. 上下文：因为是函数式接口，可以推断出方法声明为 int compare(T o1, T o2)，这步方法声明还不能省，因为参数怎么用还没定
    //3. 方法体仅一行：因为只有一行，所以省略方法体的 return
    //4. 方法引用类型：方法引用的是静态方法，可以推断出方法参数的对应位置，即实际为 Demo.staticM(o1, o2)，
    //   所以省略方法声明（函数式接口和方法体的）
    //记忆：
    //1. 如果是看别人用（从方法引用还原完整写法）：从 4 推 1
    //2. 如果是自己写（函数式接口、仅一行）：从 1 推 4
    Arrays.sort(data, Demo::staticM);

    //等价于：省略了类声明、return
    Arrays.sort(data, (a, b) -> Demo.staticM(a,b));
    //等价于
    Arrays.sort(data, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Demo.staticM(o1, o2);
      }
    });

    System.out.println(Arrays.toString(data));
  }

  @Test(description = "方法引用：实例方法")
  public void testMethodReference_instance_method() {
    Demo object = new Demo();

    //省略了类声明、方法声明和 return，只保留了方法体。
    //1. 上下文：根据上下文（形参类型）可以推断出类声明为 new MyClass implements Comparator
    //2. 上下文：因为是函数式接口，可以推断出方法声明为 int compare(T o1, T o2)，这步方法声明还不能省，因为参数怎么用还没定
    //3. 方法体仅一行：因为只有一行，所以省略方法体的 return
    //4. 方法引用类型：方法引用的是实例方法，可以推断出方法参数的对应位置，即实际为 object.instanceM(a,b)，
    //   所以省略方法声明（函数式接口和方法体的）
    //记忆：
    //1. 如果是看别人用（从方法引用还原完整写法）：从 4 推 1
    //2. 如果是自己写（函数式接口、仅一行）：从 1 推 4
    Arrays.sort(data, object::instanceM);

    //等价于：省略了类声明、return
    Arrays.sort(data, (a, b) -> object.instanceM(a,b));
    //等价于
    Arrays.sort(data, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return object.instanceM(o1, o2);
      }
    });

    System.out.println(Arrays.toString(data));
  }

  @Test(description = "方法引用：任意对象的实例方法")
  public void testMethodReference_anyObject_instance_method() {

    //省略了类声明、方法声明和 return，只保留了方法体。
    //1. 上下文：根据上下文（形参类型）可以推断出类声明为 new MyClass implements Comparator
    //2. 上下文：因为是函数式接口，可以推断出方法声明为 int compare(T o1, T o2)，这步方法声明还不能省，因为参数怎么用还没定
    //3. 方法体仅一行：因为只有一行，所以省略方法体的 return
    //4. 方法引用类型：方法引用的是任意对象的实例方法，可以推断出方法参数的对应位置，即实际为 a.compareToIgnoreCase(b)，
    //   所以省略方法声明（函数式接口和方法体的）
    //记忆：
    //1. 如果是看别人用（从方法引用还原完整写法）：从 4 推 1
    //2. 如果是自己写（函数式接口、仅一行）：从 1 推 4
    Arrays.sort(data, String::compareToIgnoreCase);

    //等价于：省略了类声明、return
    Arrays.sort(data, (a, b) -> a.compareToIgnoreCase(b));
    //等价于
    Arrays.sort(data, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
      }
    });

    System.out.println(Arrays.toString(data));
  }

  @Test(description = "方法引用：构造器")
  public void testMethodReference_new_constructor() {

    //省略了类声明、方法声明和 return，只保留了方法体。
    //1. 上下文：根据上下文（形参类型）可以推断出类声明为 new MyClass implements Supplier
    //2. 上下文：因为是函数式接口，可以推断出方法声明为 T get()，这步方法声明还不能省，因为参数怎么用还没定
    //3. 方法体仅一行：因为只有一行，所以省略方法体的 return
    //4. 方法引用类型：方法引用的是构造器，可以推断出方法参数的对应位置，即实际为 new T()，
    //   所以省略方法声明（函数式接口和方法体的）
    //记忆：
    //1. 如果是看别人用（从方法引用还原完整写法）：从 4 推 1
    //2. 如果是自己写（函数式接口、仅一行）：从 1 推 4
    HashSet<String> set1 = Demo.transfer(data, HashSet::new);

    //等价于：省略了类声明、return
    HashSet<String> set2 = Demo.transfer(data, () -> new HashSet());
    //等价于
    HashSet<String> set3 = Demo.transfer(data, new Supplier<HashSet>() {

      @Override
      public HashSet get() {
        return new HashSet();
      }

    });

    System.out.println(set1);
    System.out.println(set2);
    System.out.println(set3);
  }

  @Test(description = "使用场景：替换匿名内部类")
  public void testUseInAnonymousClass() {

    System.out.println("使用匿名内部类");
    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("come on");
      }
    }).start();

    System.out.println("使用 Lambda 表达式");
    new Thread(()-> System.out.println("come on")).start();

    Factory factory = new Factory();
    factory.manufacture(() -> System.out.println("制造杯子"));
  }

  @Test(description = "使用场景：替换 for 循环")
  public void testUseInFor() {
    List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");

    System.out.println("普通 for 循环");
    for (int i = 0; i < features.size(); i++) {
      System.out.println(features.get(i));
    }

    System.out.println("箭头运算符 ->");
    String p = "p";
    features.forEach(n -> System.out.println(p+n));

    System.out.println("方法引用，双冒号 ::");
    // System.out::println 等价于 x -> System.out.println(x)
    features.forEach(System.out::println);

    Object[] objects = new String[3];

  }


  @Test(description = "测试 lambda 表达式的自由变量")
  public void testLambdaScope() {
    String text = "Hello";
    ActionListener listener = event -> System.out.println(text);

    // 如果自由变量在 lambda 表达式中使用，这个自由变量应该是最终变量，即不会再重新赋值。
    // text = "World"; // error

    // 这里需要注意几点：
    // （1）Timer 是守护线程（可以从虚拟机快照中看出来），所以要在主线程中等待一段时间，让 Timer 进入 Runnable 状态。
    // （2）防止 Timer 一直运行，无法终止：
    // 方法一：delay 要大于 1000（基本在 1000 最近范围左右），否则 Timer 会一直运行，原因和 Swing 的关闭机制有关。
    // 方法二：声明一个变量（Timer timer = new Timer(700,listener); timer.start())，使用 timer.stop() 终止线程。
    // （3）不要在 TestNG 或 Junit 中运行多线程代码，在 @Test 方法中执行多线程的结果并不准确，原因和单元测试框架的原理有关。
    new Timer(700,listener).start();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}