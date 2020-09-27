package com.liyun.qa.edu.testng;

import com.liyun.qa.edu.testng.listener.simple.SimpleExecutionListener;
import com.liyun.qa.edu.testng.listener.retry.SampleAnnotationTransformer;
import com.liyun.qa.edu.testng.listener.ListenerTest2;
import com.liyun.qa.edu.testng.listener.ListenerTest4;
import org.testng.TestNG;

/**
 * 自定义 TestNG 运行器
 *
 * @author Li Yun
 * @date 2020/5/12 21:41
 */
public class CustomRunner {

  public static void main(String[] args) {
    TestNG testNG = new TestNG();
    testNG.addExecutionListener(new SimpleExecutionListener());
    testNG.addListener(new SampleAnnotationTransformer());
    testNG.setTestClasses(new Class[]{ListenerTest2.class, ListenerTest4.class});
    testNG.run();
  }

}
