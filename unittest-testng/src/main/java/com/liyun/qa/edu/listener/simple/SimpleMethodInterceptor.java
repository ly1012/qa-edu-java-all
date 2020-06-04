package com.liyun.qa.edu.listener.simple;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.List;

/**
 * {@link org.testng.IMethodInterceptor} 测试
 *
 * 方法拦截器。
 * 拦截对象： XML test 标签
 * 拦截时机：{@link org.testng.ITestListener#onStart(ITestContext)} 之后，任何测试（包括配置方法）运行之前
 *
 * 应用场景：
 *        1. 更改测试方法列表执行顺序
 *
 * @Listeners 作用域：
 * 针对 test 标签，如果一个 test 标签下有 @Listeners({SimpleMethodInterceptor.class})，其他没有该注解的 test 标签不会生效。
 *
 * @author Li Yun
 * @date 2020/5/12 16:59
 */
public class SimpleMethodInterceptor implements IMethodInterceptor {

  @Override
  public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
    for (IMethodInstance methodInstance : methods){
      System.out.println(methodInstance);
    }
    return methods;
  }

}
