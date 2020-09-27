package com.liyun.qa.edu.java.grammar.oop.xextends;

/**
 * 父类：父亲
 * @author Li Yun
 * @date 2018/12/19 16:20
 */
public class Parent {

  public static String name = "Dad";

  public Parent(){
    System.out.println("Parent: " + this.getClass());
  }

  public static Son eat(){
    System.out.println("米");
    return  new Son();
  }

  public void sing(String o){
    System.out.println(o);
  }

}
