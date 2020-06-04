package entity;

import java.io.Serializable;

/**
 * 电子书实体类
 *
 * @author Li Yun
 * @date 2020/4/30 20:09
 */
public class EBook implements Cloneable, Serializable {

  //普通属性
  private Person person;
  private String name;
  private int year;

  //私有，没有 set/get 方法，基本类型
  private int privateNoSetNoGet = 0;
  //私有，没有set/get 方法，引用类型
  private Person privatePersonNoSetNoGet = new Person("private", 7);
  //公共，没有 set/get 方法，不可重新赋值，引用类型
  public final Person publicFinalNoSetNoGet = new Person("Mary",25);
  //公共，没有 set/get 方法，基本类型
  public String publicNoSetNoGet = "init";

  public EBook(){

  }

  public EBook(Person person, String name, int year) {
    this.person = person;
    this.name = name;
    this.year = year;
  }

  public void updateSomeVar(){
    this.privateNoSetNoGet = 100;
    this.publicFinalNoSetNoGet.setName("Lily");
    this.publicNoSetNoGet = "updated";
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public EBook deepClone() {
    try {
      EBook eBook = (EBook) super.clone();
      eBook.person = this.person.clone();
      eBook.privatePersonNoSetNoGet = this.privatePersonNoSetNoGet.clone();
      //WARN: 对于 final 修饰的可变对象，是无法通过 clone 方法来克隆原对象的该属性，原对象和新对象将指向同一地址
      //eBook.publicFinalNoSetNoGet = this.publicFinalNoSetNoGet.clone();
      return eBook;
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException("对象拷贝失败", e);
    }
  }

  public EBook shadowClone() {
    try {
      EBook eBook = (EBook) super.clone();
      return eBook;
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException("对象拷贝失败", e);
    }
  }

  @Override
  public String toString() {
    return "EBook{" +
        "HashCode=" + this.hashCode() +
        ", person=" + person +
        ", name='" + name + '\'' +
        ", year=" + year +
        ", privateNoSetNoGet=" + privateNoSetNoGet +
        ", privatePersonNoSetNoGet=" + privatePersonNoSetNoGet +
        ", publicFinalNoSetNoGet=" + publicFinalNoSetNoGet +
        ", publicNoSetNoGet='" + publicNoSetNoGet + '\'' +
        '}';
  }

}
