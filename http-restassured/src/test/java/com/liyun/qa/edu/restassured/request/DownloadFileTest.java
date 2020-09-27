package com.liyun.qa.edu.restassured.request;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 下载文件测试
 *
 * @author Li Yun
 * @date 2020/7/8 16:22
 */
public class DownloadFileTest {

  @Test(description = "下载图片到本地")
  public void testDownloadFile(){
    //发起下载请求
    String url = "https://img.liyunx.com/idea/jdk_sourcecode_ide.jpg";
    byte[] image = RestAssured.get(url).asByteArray();
    //存储文件到本地
    String path = "E:\\workspace\\img.liyunx.com\\2020\\jdk_sourcecode_ide.jpg";
    try(OutputStream outputStream = new FileOutputStream(path)){
      outputStream.write(image);
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

}
