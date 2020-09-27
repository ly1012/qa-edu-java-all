package com.liyun.qa.edu.java.grammar.oop;

import com.liyun.qa.edu.java.entity.EBook;
import com.liyun.qa.edu.java.entity.EBookNotImplementCloneable;
import com.liyun.qa.edu.java.entity.Person;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.BeanUtils;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 对象拷贝测试
 *
 * @author Li Yun
 * @date 2020/4/30 20:12
 */
public class ObjectCopyTest {

  @Test(description = "没有实现 Cloneable 接口，直接调用 super.clone() 方法将抛出 CloneNotSupportedException ",
      expectedExceptions = CloneNotSupportedException.class)
  public void testCloneNotSupportedException() throws CloneNotSupportedException {
    new EBookNotImplementCloneable().clone();
  }

  @Test(description = "对象浅拷贝，属性一对一精确拷贝")
  public void testShadowCopyByClone() {
    //原对象
    Person person = new Person("Cay S. Horstmann",30);
    EBook eBook = new EBook(person,"《Java核心技术 第10版》", 2018);
    //对原对象进行部分修改
    eBook.updateSomeVar();
    System.out.println("原对象 "+eBook);

    //新对象=原对象的拷贝
    EBook eBook2 = eBook.shadowClone();
    //通过 clone() 浅拷贝，没有 set/get 方法的 private 和 public 属性也会被拷贝
    System.out.println("新对象 "+eBook2);

    //修改新对象
    eBook2.getPerson().setName("tom");  //新对象和原对象的 person 指向同一个地址
    eBook2.setName("《Python 编程》");
    eBook2.setYear(2087);

    //可变引用类型，因为指向同一个内存地址，有影响。
    //如果 eBook2.setPerson(person.clone()) 则没有影响，这也是深拷贝的特性，即引用类型将继续拷贝
    assertThat(eBook.getPerson()).isEqualTo(eBook2.getPerson()).isEqualTo(person);
    //引用类型 String，不影响
    assertThat(eBook.getName()).isNotEqualTo(eBook2.getName()).isEqualTo("《Java核心技术 第10版》");
    //基本类型，不影响
    assertThat(eBook.getYear()).isNotEqualTo(eBook2.getYear());
  }

  @Test(description = "对象浅拷贝，通过反射实现")
  public void testShadowCopyByReflect() {
    //原对象
    Person person = new Person("Cay S. Horstmann",30);
    EBook eBook = new EBook(person,"《Java核心技术 第10版》", 2018);
    //对原对象进行部分修改
    eBook.updateSomeVar();
    System.out.println("原对象 "+eBook);

    //将原对象的属性拷贝到新对象
    EBook eBook2 = new EBook();
    BeanUtils.copyProperties(eBook, eBook2);
    //通过反射深拷贝，没有 set/get 方法的属性不会被拷贝，
    System.out.println("新对象 "+eBook2);
  }

  @Test(description = "对于类中 final 修饰的引用类型属性，每次 new 创建对象后，该属性的 hashcode 是不同的")
  public void testFinalRefObject() {
    Person person = new Person("Cay S. Horstmann",30);
    EBook eBook = new EBook(person,"《Java核心技术 第10版》", 2018);

    Person person2 = new Person("Cay S. Horstmann",30);
    EBook eBook2 = new EBook(person2,"《Java核心技术 第10版》", 2018);

    assertThat(eBook.publicFinalNoSetNoGet.hashCode())
        .isNotEqualTo(eBook2.publicFinalNoSetNoGet.hashCode());
  }

  @Test(description = "对象深拷贝，通过 clone 方法实现")
  public void testDeepCopyByClone() {
    //原对象
    Person person = new Person("Cay S. Horstmann",30);
    EBook eBook = new EBook(person,"《Java核心技术 第10版》", 2018);
    //对原对象进行部分修改
    eBook.updateSomeVar();
    System.out.println("原对象 "+eBook);

    //新对象=原对象的拷贝
    EBook eBook2 = eBook.deepClone();
    //通过 clone() 深拷贝，没有 set/get 方法的 private 和 public 属性也会被拷贝
    //另外，注意到 publicFinalNoSetNoGet 是 final 修饰的可变对象，因此该实现下，仍然是原对象的地址
    System.out.println("新对象 "+eBook2);
  }

  @Test(description = "对象深拷贝，通过序列化/反序列化实现")
  public void testDeepCopyBySerialize() {
    //原对象
    Person person = new Person("Cay S. Horstmann",30);
    EBook eBook = new EBook(person,"《Java核心技术 第10版》", 2018);
    //对原对象进行部分修改
    eBook.updateSomeVar();
    System.out.println("原对象 "+eBook);

    //新对象=原对象的拷贝
    EBook eBook2 = SerializationUtils.clone(eBook);
    //通过序列化深拷贝，没有 set/get 方法的 private 和 public 属性也会被拷贝
    //另外，注意到 publicFinalNoSetNoGet 重新创建了对象，不再是原对象的地址
    System.out.println("新对象 "+eBook2);
  }




}
