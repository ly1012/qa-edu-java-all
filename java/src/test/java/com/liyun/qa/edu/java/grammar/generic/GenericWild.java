package com.liyun.qa.edu.java.grammar.generic;

import org.testng.annotations.Test;

/**
 * 通配符类型
 *
 * 辅助记忆口诀：声明类型实际类型 + 区间 + 安全编译（通配符类型不确定）
 * 1. 赋值语句：声明类型 >= 实际类型（运行时类型）
 * 2. 只需要考虑方法声明，不需要考虑方法体。方法调用时，方法参数是声明类型（实际值赋值给它），方法返回值是实际类型（要赋值给变量）。
 *    - 方法参数：  method(形参类型);                形参类型（声明类型） >= 实参类型（实际类型）
 *    - 方法返回值：变量类型 var = 方法返回值类型;    变量类型（声明类型） >= 方法返回值类型（实际类型）
 * 3. ? super T 等于类型是 [T, ) 上区间，编译器不确定 -> 赋值时只能用于声明类型 -> 只能用于方法参数
 * 4. ? extends T 等于类型是 ( ,T] 下区间，编译器不确定 -> 赋值时只能用于实际类型 -> 只能用于返回值
 *
 * @author Li Yun
 * @date 2020/8/8 14:07
 */
public class GenericWild {

  @Test(description = "下界通配符，只能存")
  public void testSuper() {
    Plate<? super CSon> plate = new Plate<CParent>();

    //存，即方法参数类型
    //plate.set(new CGrandPa());    //error
    //plate.set(new CParent());     //error
    plate.set(new CSon());
    plate.set(new CChild());

    //取：以下全部编译报错
    //CGrandPa cGrandPa = plate.get();
    //CParent cParent = plate.get();
    //CSon cSon = plate.get();
    //CChild cChild = plate.get();
  }

  @Test(description = "上界通配符，只能取")
  public void testExtends() {
    Plate<? extends CSon> plate = new Plate<CSon>();

    //取，即返回值类型
    //返回值是 CSon 本身或 Cson 的子类（编译器不确定），所以声明类型可以是 CSon 本身或 CSon 的父类
    CGrandPa cGrandPa = plate.get();
    CParent cParent = plate.get();
    CSon cSon = plate.get();
    //CChild cChild = plate.get();  //error

    //存：以下全部编译报错
    //方法参数类型时 CSon 本身或 Cson 的子类（编译器不确定）
    //1. 因为是 extends，所以 CSon 的父类肯定编译不通过
    //2. 如果是 CSon 或 CChild，因为编译器不确定实际类型，有可能是 CGrandSon 甚至更小，所以所有子类也编译不通过
    //总结 => 有两点因素，第一：类型变量的限定，第二：编译器的解释（多态，声明类型 - 实际类型）。
    //plate.set(new CGrandPa());
    //plate.set(new CParent());
    //plate.set(new CSon());
    //plate.set(new CChild());
  }
}

class Plate<T>{

  private T t;

  public void set(T t){
    this.t = t;
  }

  public T get(){
    return t;
  }

}

class CGrandPa {}

class CParent extends  CGrandPa {}

class CSon extends CParent {}

class CChild extends  CSon {}

