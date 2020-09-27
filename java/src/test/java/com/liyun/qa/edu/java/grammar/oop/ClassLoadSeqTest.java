package com.liyun.qa.edu.java.grammar.oop;

import org.testng.annotations.Test;

/**
 *
 * @author Li Yun
 * @date 2020/8/3 15:11
 */
public class ClassLoadSeqTest {

  class Father{
    public int money = 1;

    public Father(){
      money = 2;
      showMeTheMoney();
    }

    public void showMeTheMoney() {
      System.out.println("I'm Father, i have $" + money);
    }

  }

  class Son extends Father{
    public int money = 3;

    public Son(){
      money = 4;
      showMeTheMoney();
    }

    public void showMeTheMoney() {
      System.out.println("I'm Son, i have $" + money);
    }

  }

  @Test
  public void testClassLoadSeq() {
    Father guy = new Son();
    System.out.println("This guy has $" + guy.money);
    //输出：
    //I'm Son, i have $0
    //I'm Son, i have $4
    //This guy has $2
  }

}
