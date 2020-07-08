package grammar.oop.xinterface;

/**
 * 接口语法
 * @date 2020/5/16 12:48
 * @author Li Yun
 */
public interface InterfaceTest {

  //----------------成员变量-----------------------
  //成员变量默认使用 public static final 修饰

  public static final String name = "abc";


  //----------------方法---------------------------
  //方法默认使用 public 修饰，且不能用 protected 修饰

  //接口中不能有构造器（抽象类可以有构造器）

  //默认是抽象方法
  public abstract String p0();

  //JDK8 中可以有静态方法
  // 1. static 方法要有方法体，这个容易理解。
  // 2. 这个方法不能由实现它的类继承。因为一个类可以实现多个接口，如果2个接口具有相同的 static 方法，则它们都将被继承，编译器将不知道要调用哪个。
  public static void p1(String n){
    System.out.println(name);
  }

  //JDK8 中可以有默认方法
  //可以被子类继承，子类指实现类。
  //default 方法可以被子类重写。如果一个类实现多个接口，多个接口有相同 default 方法，则子类必须重写该方法。
  public default void p2(String n){
    System.out.println(name);
  }

  //--------------内部类----------------------
  //内部类默认使用 public static 修饰，且不能用 protected、default 修饰

  public static class Inner{

  }

}
