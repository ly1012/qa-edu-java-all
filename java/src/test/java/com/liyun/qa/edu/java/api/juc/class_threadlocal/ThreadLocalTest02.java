package com.liyun.qa.edu.java.api.juc.class_threadlocal;

/**
 * {@link ThreadLocal} 应用场景二：
 * 【内容不同】每个线程内需要独立保存信息，以便供其他方法更方便地获取该信息的场景。
 *
 * 代码出处：https://kaiwu.lagou.com/course/courseInfo.htm?courseId=16#/detail/pc?id=282
 */
public class ThreadLocalTest02 {

  public static void main(String[] args) {
    new Service1().service1();
  }
}

class Service1 {

  public void service1() {
    User user = new User("拉勾教育");
    UserContextHolder.holder.set(user);
    new Service2().service2();
  }
}

class Service2 {

  public void service2() {
    User user = UserContextHolder.holder.get();
    System.out.println("Service2拿到用户名：" + user.name);
    new Service3().service3();
  }
}

class Service3 {

  public void service3() {
    User user = UserContextHolder.holder.get();
    System.out.println("Service3拿到用户名：" + user.name);
    UserContextHolder.holder.remove();
  }
}

class UserContextHolder {

  public static ThreadLocal<User> holder = new ThreadLocal<>();
}

class User {

  String name;

  public User(String name) {
    this.name = name;
  }
}

