package com.liyun.qa.edu.jenkins_rest;

import com.cdancy.jenkins.rest.JenkinsClient;
import com.cdancy.jenkins.rest.domain.system.SystemInfo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 登录 API
 *
 * @author Li Yun
 * @date 2020/6/25 11:24
 */
public class LoginTest {

  @BeforeClass
  public void beforeClass() {
    //setProxy();
  }

  private void setProxy(){
    System.setProperty("http.proxySet", "true");
    System.setProperty("http.proxyHost", "127.0.0.1");
    System.setProperty("http.proxyPort", "8888");
    System.setProperty("https.proxyHost", "127.0.0.1");
    System.setProperty("https.proxyPort", "8888");
  }

  @Test(description = "登录 Jenkins 测试")
  public void testLogin() throws Exception {
    JenkinsClient client = JenkinsClient.builder()
        .endPoint("http://localhost2:8080") // Optional. Defaults to http://127.0.0.1:8080
        .credentials("liyun:110ec8d2e35b15aa10d982771520230461") // 推荐：用户名 + token
        //.credentials("liyun:liyun") // 或者：用户名 + 密码
        .build();

    SystemInfo systemInfo = client.api().systemApi().systemInfo();
    assertThat(systemInfo.jenkinsVersion()).isEqualTo("2.235.1");
  }

}
