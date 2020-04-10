package oop.xextends;

/**
 * 父类：父亲
 * @author Li Yun
 * @date 2018/12/19 16:20
 */
public class Parent {

  protected static Son eat(){
    System.out.println("米");
    return  new Son();
  }

}
