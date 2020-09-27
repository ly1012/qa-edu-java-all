package com.liyun.qa.edu.java.entity;

import java.io.Serializable;

/**
 * 人
 *
 * @author Li Yun
 * @date 2020/4/30 20:10
 */
public class Person implements Cloneable, Serializable {

  private String name;
  private int age;

  public Person(){}

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public Person clone(){
    try {
      return (Person) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException("对象拷贝失败", e);
    }
  }

  @Override
  public String toString() {
    return "Person{" +
        "HashCode=" + this.hashCode() +
        ", name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
