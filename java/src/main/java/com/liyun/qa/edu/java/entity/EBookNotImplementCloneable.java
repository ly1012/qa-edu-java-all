package com.liyun.qa.edu.java.entity;

/**
 * 电子书实体类
 *
 * @author Li Yun
 * @date 2020/4/30 20:09
 */
public class EBookNotImplementCloneable {

  private Person person;
  private String name;
  private int year;

  public EBookNotImplementCloneable(){

  }

  public EBookNotImplementCloneable(Person person, String name, int year) {
    this.person = person;
    this.name = name;
    this.year = year;
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

  public EBookNotImplementCloneable clone() throws CloneNotSupportedException {
    return (EBookNotImplementCloneable) super.clone();
  }

}
