package com.liyun.qa.edu.testng.listener.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * 失败重试策略类
 *
 * @author Li Yun
 * @date 2020/5/12 20:51
 */
public class RetryStrategy implements IRetryAnalyzer {

  private int retryCount = 0;                     //当前重试次数
  private static final int MAX_RETRY_COUNT = 3;   //最大重试次数

  @Override
  public boolean retry(ITestResult result) {
    if (!result.isSuccess()){               //如果测试方法执行失败
      if (retryCount < MAX_RETRY_COUNT){    //如果小于最大次数，继续重试
        retryCount++;
        return true;
      }else {                               //如果超过最大次数，重置失败次数并返回结束重试。
        retryCount = 0;                     //重置原因：当 XML 的 suite 中一个类出现多次时，第二次运行该类，retryCount 将等于 3，导致失败重试失效
        return false;
      }
    }
    return false;
  }

}
