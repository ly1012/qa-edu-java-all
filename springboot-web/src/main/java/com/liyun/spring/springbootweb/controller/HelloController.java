package com.liyun.spring.springbootweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author Li Yun
 * @date 2020/5/4 22:30
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

  @GetMapping("/dog")
  public String dog(){
    System.out.println("cute dog");
    return "Hello dog";
  }

  @GetMapping("/baddog")
  public String baddog(){
    System.out.println("bad dog");
    throw new IllegalArgumentException("bad dog");
  }

}
