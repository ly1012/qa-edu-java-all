package com.liyun.qa.edu.testng.listener.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 *
 * @author Li Yun
 * @date 2020/8/13 21:31
 */
public class SkipRetry implements IRetryAnalyzer {

  @Override
  public boolean retry(ITestResult result) {
    return false;
  }

}
