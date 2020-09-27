package com.liyun.qa.edu.testng.listener.retry;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 注解转换器：只能用来修改 @Test 注解
 *
 * @author Li Yun
 * @date 2020/5/12 21:04
 */
public class SampleAnnotationTransformer implements IAnnotationTransformer {

  @Override
  public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
    System.out.println("开始注解转换...");
    //testMethod.getAnnotation()
    IRetryAnalyzer retryAnalyzer = annotation.getRetryAnalyzer();
    if (retryAnalyzer == null){
      annotation.setRetryAnalyzer(RetryStrategy.class);   //给每个测试方法设置默认的失败重试策略类
    }
  }

}
