package grammar.FP;

import grammar.oop.xinterface.Factory;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;


public class LambdaTest {


  @Test(description = "替换匿名内部类")
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

  @Test(description = "替换 for 循环")
  public void testUseInFor() {
    List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");

    System.out.println("普通 for 循环");
    for (int i = 0; i < features.size(); i++) {
      System.out.println(features.get(i));
    }

    System.out.println("箭头运算符 ->");
    String p = "p";
    features.forEach((n) -> System.out.println(p+n));

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