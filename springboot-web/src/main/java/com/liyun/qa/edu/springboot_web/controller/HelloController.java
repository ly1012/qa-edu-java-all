package com.liyun.qa.edu.springboot_web.controller;

import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Li Yun
 * @date 2020/5/4 22:30
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

  class Dog{
    public String name;

    public Dog(String name){
      this.name = name;
    }
  }

  @GetMapping("/dog")
  public Dog dog() throws InterruptedException {
    System.out.println("cute dog");
    Thread.sleep(3000);
    return new Dog("HaShiQi");
  }

  @PostMapping("/dashboard")
  public String baddog(@RequestParam("stat") String stat){
    String[] metrics = stat.split(",");
    // 参数校验...

    for(String metric : metrics){
      switch (metric){
        case "top5":
          //do something...
          //add data to result
        case "bugfixrate":
          //do something...
          //add data to result
        case "bugtotal":
          //do something...
          //add data to result
        default:
          break;
      }
    }

    System.out.println("bad dog");
    throw new IllegalArgumentException("bad dog");
  }

}
