package oop;

import entity.Person;
import org.testng.annotations.Test;

/**
 * final 关键字
 *
 * @author Li Yun
 * @date 2020/4/30 21:10
 */
public class FinalTest {

  private final Person person = new Person("tom",20);

  @Test
  public void testFinal() {
    //person = new Person();  //报错，final 修饰的变量不可重新赋值
    person.setName("Bob");
  }

}
