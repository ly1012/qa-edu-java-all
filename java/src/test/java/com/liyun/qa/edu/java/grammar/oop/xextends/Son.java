package com.liyun.qa.edu.java.grammar.oop.xextends;


/**
 * 子类：儿子
 * @author Li Yun
 * @date 2018/12/19 16:20
 */
public class Son extends Parent {

  public String name = "Son";

  public Son(){
    System.out.println("Son: " + this.getClass());
  }

  // 方法重写的定义
  // 前提条件：有继承关系（直接继承或间接继承）
  //
  // 1、方法名称相同
  // 2、参数列表（个数）相同
  // 3、参数类型相同
  // 4、参数顺序相同

  // 方法重写的约束
  // 方法的返回值类型：子类<=父类
  // 方法的访问权限修饰符：子类>=父类
  // 方法的 final 修饰符：如果父类有，子类不能去重写；但父类没有，子类可以有
  // 方法的 static 修饰符：子类和父类同时有或同时没有。静态方法编译期绑定（静态绑定），没有多态特性。

  public static Son eat(){
    System.out.println("面");
    return new Son();
  }

  @Override
  public void sing(String s) {
    System.out.println(s);
  }
}
