package com.liyun.qa.edu;

import com.liyun.qa.edu.listener.ListenerTest2;
import com.liyun.qa.edu.listener.ListenerTest4;
import com.liyun.qa.edu.listener.simple.SimpleExecutionListener;
import com.liyun.qa.edu.sample.retry.SampleAnnotationTransformer;
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
