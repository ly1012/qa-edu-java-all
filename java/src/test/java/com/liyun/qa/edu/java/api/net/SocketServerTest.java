package com.liyun.qa.edu.java.api.net;

import org.testng.annotations.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket 服务端
 *
 * @author Li Yun
 * @date 2020/8/27 15:36
 */
public class SocketServerTest {

  private void start(int port) throws IOException {
    //监听 port 端口
    ServerSocket serverSocket = new ServerSocket(port);

    while(true){
      //建立连接
      Socket socket = serverSocket.accept();
      System.out.format("[服务端]建立连接：%s\n", socket);

      new Thread(() -> {
        System.out.format("[服务端]开始处理客户端 %s 的消息\n",
            ((InetSocketAddress)socket.getRemoteSocketAddress()).getPort());
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        try{
          //输入流（接收消息）
          inputStream = socket.getInputStream();
          inputStreamReader = new InputStreamReader(inputStream);
          bufferedReader = new BufferedReader(inputStreamReader);
          //接受客户端消息
          String line;
          while ((line = bufferedReader.readLine()) != null){
            System.out.format("[服务端]收到客户端消息：%s\n", line);
          }

          //输出流（发送消息）
          outputStream = socket.getOutputStream();
          //发送消息到客户端
          String msg = String.format("%s", socket.getRemoteSocketAddress());
          outputStream.write(msg.getBytes());

          //关闭连接
          socket.close();
        } catch (IOException exception) {
          exception.printStackTrace();
        }finally {
          if (bufferedReader != null){
            try {
              bufferedReader.close();
            } catch (IOException exception) {
              exception.printStackTrace();
            }
          }
          if (inputStreamReader != null){
            try {
              inputStreamReader.close();
            } catch (IOException exception) {
              exception.printStackTrace();
            }
          }
          if (inputStream != null){
            try {
              inputStream.close();
            } catch (IOException exception) {
              exception.printStackTrace();
            }
          }
          if (outputStream != null){
            try {
              outputStream.close();
            } catch (IOException exception) {
              exception.printStackTrace();
            }
          }
          //关闭连接
          try {
            socket.close();
          } catch (IOException exception) {
            exception.printStackTrace();
          }
        }

      }).start();

    }
  }

  @Test(description = "测试 Socket Server")
  public void testSocketServer() throws IOException {
    start(7777);
  }

}
