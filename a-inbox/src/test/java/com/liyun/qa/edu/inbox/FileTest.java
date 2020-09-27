package com.liyun.qa.edu.inbox;

import cn.hutool.http.HttpUtil;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO <br>
 * 创建时间：2020/3/18 17:04<br>
 * 作者：李云
 */
public class FileTest {

  @Test
  public void testName12() throws IllegalAccessException, InstantiationException {
    String[] strs = {""};
    String str = String.class.newInstance();
    String.class.getClass();
    String s2 = "df";
    s2.format("","");
  }

  @Test
  public void testFileStat() {
    // URL 列表
    Set<String> urls = new HashSet<>();
    File originFile = new File("src/test/resources/http.log");
    // 获取文件内容
    Path path = Paths.get(originFile.getAbsolutePath());
    List<String> lines = null;
    try {
      lines = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // 遍历文件内容
    for (String line : lines) {
      String url = "";
      // 提取 url
      Pattern pattern = Pattern.compile("(https?://[\\S]*)( |)");
      Matcher matcher = pattern.matcher(line);
      while (matcher.find()) {
        url = matcher.group(1);
        // 发送请求
        boolean flag = true;
        try {
          HttpUtil.get(url);
        } catch (Exception e) {
          // 请求失败
          flag = false;
        }

        // 如果请求正确，放入列表
        if (flag) urls.add(url);
      }

    }

    // 格式化输出
    StringBuffer sb = new StringBuffer();
    for (String url : urls) {
      sb.append(url);
      sb.append("\n");
    }

    // 输出 URL 列表到文件
    File targetFile = new File("src/test/resources/url.log");
    Path urlFilePath = Paths.get(targetFile.getAbsolutePath());
    try {
      Files.write(urlFilePath, sb.toString().getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }


  }


  @Test
  public void testName() {
    String line = "https://www.taobao.com sdflsdf http://www.baidu.com dsf";
    // 提取 url
    String url = "";
    Pattern pattern = Pattern.compile("(https://[\\S]*|http://[\\S]*) ");
    Matcher matcher = pattern.matcher(line);
    while (matcher.find()) {
      url = matcher.group(1);
      System.out.println(url);
    }
  }

  @Test
  public void testName1() {
    File file = new File("src/test/resources/http.log");
    System.out.println(file.getAbsolutePath());
    Path path = Paths.get(file.getAbsolutePath());
    System.out.println(path.toString());
  }
}
