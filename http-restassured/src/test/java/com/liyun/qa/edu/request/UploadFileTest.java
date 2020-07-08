package com.liyun.qa.edu.request;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

/**
 * 上传文件测试
 *
 * @author Li Yun
 * @date 2020/5/2 16:17
 */
public class UploadFileTest {

  @BeforeClass
  public void beforeClass() {
    //RestAssured.proxy("127.0.0.1", 8888);
    RestAssured.useRelaxedHTTPSValidation();
  }

  //实际发送的请求报文：
  //POST https://sm.ms/api/v2/upload HTTP/1.1
  //Authorization: xxxx
  //Accept: */*
  //User-Agent: PostmanRuntime/7.24.1
  //Content-Length: 11556
  //Content-Type: multipart/form-data; boundary=ndgBcY_0fQw9t1qSwSmxHiVNDnKO5ysUftZQp
  //Host: sm.ms
  //Connection: Keep-Alive
  //Accept-Encoding: gzip,deflate
  //
  //--ndgBcY_0fQw9t1qSwSmxHiVNDnKO5ysUftZQp
  //Content-Disposition: form-data; name="format"
  //Content-Type: text/plain; charset=US-ASCII
  //Content-Transfer-Encoding: 8bit
  //
  //json
  //--ndgBcY_0fQw9t1qSwSmxHiVNDnKO5ysUftZQp
  //Content-Disposition: form-data; name="smfile"; filename="filezilla_g9c6Y8U9u03s2bRrXhf7.png"
  //Content-Type: image/png
  //Content-Transfer-Encoding: binary

  //接口文档：https://doc.sm.ms/#api-Image-Upload
  @Test(description = "文件上传测试，Content-Type: multipart/form-data")
  public void testUploadFile() {

    String imgPath = "E:\\workspace\\img.liyunx.com\\filezilla\\filezilla_g9c6Y8U9u03s2bRrXhf7.png";
    File file = new File(imgPath);

    JsonPath jsonPath =
        given()
            //访问安全令牌
            .header("Authorization", "xxxx")
            //绕过反爬虫检测
            .header("User-Agent", "PostmanRuntime/7.24.1")
            //Content-Type: multipart/form-data key(name):format value:json
            .multiPart("format", "json")
            //Content-Type: multipart/form-data key(name):smfile value:文件内容
            .multiPart("smfile", file, "image/png")
            .log().all()  //打印请求报文
            .when().post("https://sm.ms/api/v2/upload")
            .then()
            .log().all()  //打印响应报文
            .extract().body().jsonPath();
  }

}
