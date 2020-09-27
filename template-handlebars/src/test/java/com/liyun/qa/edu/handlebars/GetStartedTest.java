package com.liyun.qa.edu.handlebars;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * 初次上手
 *
 * @author Li Yun
 * @date 2020/6/22 18:16
 */
public class GetStartedTest {

  @Test(description = "小试牛刀")
  public void test1() throws IOException {
    Handlebars handlebars = new Handlebars();
    //编译模板字符串为 Java 对象，this
    Template template = handlebars.compileInline("Hello {{this}} {{this}}!");
    //使用上下文对象渲染模板
    System.out.println(template.apply("Handlebars.java"));
  }

}
