package com.liyun.qa.edu.java.api.net;

import org.testng.annotations.Test;

import java.io.*;
import java.net.Socket;

/**
 * socket 客户端
 *
 * @author Li Yun
 * @date 2020/8/27 15:56
 */
public class SocketClientTest {

  private void start(int i) throws IOException {
    //建立连接
    Socket socket = new Socket("127.0.0.1", 7777);
    System.out.format("[客户端 %d]建立连接\n", i);

    OutputStream outputStream = null;
    InputStream inputStream = null;
    InputStreamReader inputStreamReader = null;
    BufferedReader reader = null;
    try{
      //输出流（发送消息出去）
      outputStream = socket.getOutputStream();
      //发送消息到服务端
      outputStream.write(("Hello from client" + i).getBytes());
      outputStream.flush();
      socket.shutdownOutput();

      //输入流（接收消息）
      inputStream = socket.getInputStream();
      inputStreamReader = new InputStreamReader(inputStream);
      reader = new BufferedReader(inputStreamReader);
      //接收服务端消息
      String line;
      while((line = reader.readLine()) != null){
        System.out.format("[客户端]收到服务端消息：%s\n", line);
      }

    } catch (IOException exception) {
      exception.printStackTrace();
    }finally {
      if (outputStream != null){
        outputStream.close();
      }
      if (reader != null){
        reader.close();
      }
      if (inputStreamReader != null){
        inputStreamReader.close();
      }
      if (inputStream != null){
        inputStream.close();
      }
      //关闭连接
      socket.close();
    }

  }

  @Test(description = "测试 socket client")
  public void testSocketClient() throws IOException {
    for (int i = 0; i < 5; i++){
      start(i);
    }
  }

}
