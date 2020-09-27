package com.liyun.qa.edu.restassured.request;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

/**
 * get 请求测试
 *
 * @author Li Yun
 * @date 2020/5/2 16:17
 */
public class GetTest {

  @Test
  public void testGetAndJsonRes() {
    JsonPath jsonPath = RestAssured.get("https://reqres.in/api/users/2").andReturn().jsonPath();
    String str = jsonPath.getString("data.id");
    System.out.println(str);
  }
}
