package com.liyun.qa.edu.allure;

import io.qameta.allure.Allure;
import io.qameta.allure.model.TestResult;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Li Yun
 * @date 2020/6/24 0:51
 */
public class BugListener extends TestListenerAdapter {

  private ThreadLocal<TestResult> allureTestCaseResult = new ThreadLocal<>();

  @Override
  public void onTestFailure(ITestResult tr) {
    super.onTestFailure(tr);

    //将输出到报告的日志以附件形式发送到 Allure
    //  1. 输出日志到报告：Reporter.log(String s);
    //  2. 输出到报告和控制台：Reporter.log(String s, boolean logToStandardOut);
    Allure.attachment("控制台日志", String.valueOf(Reporter.getOutput(tr)));

    //自动提交 Bug
    //  1. 获取 Bug 信息并组装成指定格式
    Allure.getLifecycle().updateTestCase(testResult -> allureTestCaseResult.set(testResult));
    TestResult atr = allureTestCaseResult.get();    // Allure 测试结果，包括步骤、附件等信息
    System.out.println("=======Bug 详细信息开始===========");
    List<String> list = new ArrayList<>();
    list.add(atr.getFullName());
    list.add(tr.getThrowable().toString());
    System.out.println(String.join("\n",list));
    System.out.println("=======Bug 详细信息结束===========");
    //  2. 调用缺陷管理系统 API 提交 Bug
    //...
    //  3. 将 Bug 链接发送到 Allure
    //Allure.link("bug","issue", "https://www.baidu.com");
    Allure.issue("bug", "https://www.baidu.com");

  }
}
