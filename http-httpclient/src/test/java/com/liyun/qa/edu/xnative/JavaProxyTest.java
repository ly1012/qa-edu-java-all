package com.liyun.qa.edu.xnative;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Proxy 测试
 * @author Li Yun
 * @date 2019/2/25 15:00
 */
public class JavaProxyTest {

  private static final String proxyHost = "127.0.0.1";
  private static final String proxyPort = "8888";
  //private static final String URL = "http://nav.qadoc.org/cn/index.html";
  private static final String URL = "https://www.baidu.com";

  @Test(description = "开启 HTTP 代理，方式一：设置系统属性")
  //代理设置错误或无法访问时，忽视代理，正常返回
  public void testJavaProxy() {
    //开启 HTTP 代理
    System.setProperty("http.proxySet", "true");
    System.setProperty("http.proxyHost", proxyHost);
    System.setProperty("http.proxyPort", proxyPort);

    //开启 HTTPS 代理
    System.setProperty("https.proxyHost", proxyHost);
    System.setProperty("https.proxyPort", proxyPort);

    //发起 HTTP 请求进行测试
    connectAndPrint();
  }

  @Test(description = "开启 HTTP 代理，方式二：使用 Proxy 对象")
  //代理设置错误或无法访问时，抛出 java.net.ConnectException: Connection refused: connect
  public void testJavaProxy2() {
    //开启 HTTP 代理
    Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(proxyHost, Integer.valueOf(proxyPort)));
    //发起 HTTP 请求进行测试
    connectAndPrint(proxy);
  }

  private void connectAndPrint() {
    try{
      if (URL.startsWith("https")){
        connectAndPrintInHttps(false, null);
      }else {
        connectAndPrintInHTTP(false, null);
      }
    }catch (SSLHandshakeException ssle){
     // ignore
    }catch (Exception e){
      Assertions.fail(e.getMessage());
      e.printStackTrace();
    }
  }

  private void connectAndPrint(Proxy proxy) {
    try{
      if (URL.startsWith("https")){
        connectAndPrintInHttps(true, proxy);
      }else {
        connectAndPrintInHTTP(true, proxy);
      }
    }catch (SSLHandshakeException ssle){
      // ignore
    }catch (Exception e){
      Assertions.fail(e.getMessage());
      e.printStackTrace();
    }
  }

  //发起请求
  private void connectAndPrintInHttps(boolean isProxy, Proxy proxy) throws Exception {
    //HTTPS 处理
    SSLContext sc = SSLContext.getInstance("SSL");
    //指定信任 https
    sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());

    URL url = new URL(URL);
    HttpsURLConnection connection = null;
    if (isProxy){
      connection = (HttpsURLConnection) url.openConnection(proxy);
    }else {
      connection = (HttpsURLConnection)url.openConnection();
    }

    //HTTPS 处理
    connection.setSSLSocketFactory(sc.getSocketFactory());
    connection.setHostnameVerifier(new TrustAnyHostnameVerifier());

    connection.setDoOutput(true);
    connection.setRequestMethod("GET");
    System.out.println(connection.getResponseCode());
    System.out.println(connection.getResponseMessage());
    System.out.println(connection.getContentType());
    try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
      String line;
      while ((line = br.readLine()) != null){
        System.out.println(line);
      }
    }
  }

  //发起请求
  private void connectAndPrintInHTTP(boolean isProxy, Proxy proxy) throws Exception {
    URL url = new URL(URL);
    HttpURLConnection connection = null;
    if (isProxy){
      connection = (HttpURLConnection) url.openConnection(proxy);
    }else {
      connection = (HttpURLConnection)url.openConnection();
    }

    connection.setDoOutput(true);
    connection.setRequestMethod("GET");
    System.out.println(connection.getResponseCode());
    System.out.println(connection.getResponseMessage());
    System.out.println(connection.getContentType());
    try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
      String line;
      while ((line = br.readLine()) != null){
        System.out.println(line);
      }
    }
  }

  private static class TrustAnyTrustManager implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
      return new X509Certificate[] {};
    }
  }

  private static class TrustAnyHostnameVerifier implements HostnameVerifier {
    public boolean verify(String hostname, SSLSession session) {
      return true;
    }
  }

}
