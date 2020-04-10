package oop.xinterface;

/**
 * 函数式接口
 */
@FunctionalInterface
public interface Worker {

  // 函数式接口有且仅有一个抽象方法
  void work();

  //Java 8 中接口添加 static 方法的几个限制：
  // 1. static 方法要有方法体，这个容易理解。
  // 2. 这个方法不能由实现它的类继承。因为一个类可以实现多个接口，如果2个接口具有相同的 static 方法，则它们都将被继承，编译器将不知道要调用哪个。
  public static void eat(String foodName){
    System.out.println("eat " + foodName);
  }

  // since JDK 1.8
  default void breathe(){
    System.out.println("呼");
    System.out.println("吸");
  }

}
