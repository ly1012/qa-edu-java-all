package com.liyun.qa.edu.sshj;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.Security;

/**
 * sshj 教学 <br>
 * 创建时间：2019/3/25 17:50<br>
 * 作者：李云
 */
public class SSHJTest {


  @Test()
  public void testSSH(){
    String s = exec("10.200.130.140","root","Tairan@2018#QA","cd /etc;ls");
    System.out.println(s);
  }

  private String exec(String ip,String user,String password,String cmd){
    SSHClient ssh = new SSHClient();
    Security.setProperty("crypto.policy","unlimited");

    InputStream in = null;
    InputStreamReader isr = null;
    BufferedReader reader = null;
    Session.Command cmdo = null;
    Session session = null;

    ssh.setTimeout(300);
    ssh.addHostKeyVerifier(new PromiscuousVerifier());
    StringBuffer sb = null;
    try {
      //建立连接
      ssh.connect(ip);
      //登录授权
      ssh.authPassword(user, password);
      //开启一个Session
      session = ssh.startSession();
      session.allocateDefaultPTY(); // 必须加上这句，否则多个session的时候，session.close() 方法关闭异常，报 Timeout expired
      //执行命令
      cmdo = session.exec(cmd);
      //获取命令执行结果流
      in = cmdo.getInputStream();
      isr = new InputStreamReader(in, StandardCharsets.UTF_8);
      reader = new BufferedReader(isr);
      String line;
      sb = new StringBuffer();
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try{
        if (reader != null){
          reader.close();
        }
        if (isr != null){
          isr.close();
        }
        if (in != null){
          in.close();
        }
        if (cmdo != null){
          cmdo.close();
        }
        if (session != null){
          session.close();
        }
        if(ssh != null){
          ssh.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return sb.toString();
  }


}
