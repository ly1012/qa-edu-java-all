package com.liyun.qa.edu.design_pattern.singleton;

/**
 * 枚举类（线程安全）
 *
 * @author Li Yun
 * @date 2020/9/10 23:44
 */
public enum Singleton06 {

  INSTANCE;

  //【测试】本方法（构造器）可以省略，只是说明 INSTANCE 实例化过程，INSTANCE = new Singleton06()
  Singleton06(){
    System.out.println("INSTANCE 实例化成功");
  }

  //【测试】本方法可以省略，只是为了说明枚举法实现的用法。
  public void whateverMethod() {
    System.out.println("doSomething...");
  }

  //【测试】本方法可以省略，只是为了说明枚举法实现的用法。
  public static void main(String[] args) {
    Singleton06 instance = Singleton06.INSTANCE;
    instance.whateverMethod();
  }

}
