package api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.net.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 获取设备信息 <br>
 * 创建时间：2019/3/28 14:15<br>
 * 作者：李云
 */
public class GetDeviceInfoTest {

  private static final Logger log = LoggerFactory.getLogger(GetDeviceInfoTest.class);

  //准确获取本机IP
  static InetAddress addrLAN;
  //获取本机IP，可能准确
  static InetAddress addr;

  Properties props = System.getProperties();

  static {
    try {
      addrLAN =  getLocalHostLANAddress();
      addr = getLocalHostAddress();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

  @AfterMethod
  public void afterMethod(){
    System.out.println();
  }


  /*
   * 参考资料：
   * 1. [Java 实例 - 获取本机ip地址及主机名](www.runoob.com/java/net-localip.html)
   * 2. [详谈再论JAVA获取本机IP地址](https://www.cnblogs.com/starcrm/p/7071227.html)
   */
  @Test(description = "获取本机 IP")
  public void testGetLocalIP(){
    log.info("本机IP（准确）: {}", addrLAN.getHostAddress());
    log.info("本机IP（可能准确）: {}", addr.getHostAddress());
  }

  @Test(description = "获取本机操作系统相关信息")
  public void testGetOSInfo(){

    log.info("操作系统的名称：{}", props.getProperty("os.name"));
    log.info("操作系统的构架：{}", props.getProperty("os.arch"));
    log.info("操作系统的版本：{}", props.getProperty("os.version"));
    //在 unix 系统中是＂／＂
    log.info("文件分隔符：{}", props.getProperty("file.separator"));
    //在 unix 系统中是＂:＂
    log.info("路径分隔符：{}", props.getProperty("path.separator"));
    //在 unix 系统中是＂/n＂
    log.info("行分隔符：{}", props.getProperty("line.separator").replaceAll("\r","\\\\r").replaceAll("\n","\\\\n"));
    log.info("行分隔符：{}", System.lineSeparator().replaceAll("\r","\\\\r").replaceAll("\n","\\\\n"));

  }

  @Test(description = "获取本机用户信息")
  public void testGetUserInfo(){
    log.info("用户名称（可能准确）：{}",addrLAN.getHostName());
    log.info("用户名称（可能准确）：{}",addr.getHostName());
    log.info("用户名称："+props.getProperty("user.name"));
    log.info("用户的主目录："+props.getProperty("user.home"));
    log.info("用户的当前工作目录："+props.getProperty("user.dir"));
  }

  @Test(description = "获取本机 Java 信息")
  public void testGetJavaInfo(){
    log.info("Java 的运行环境版本：{}", props.getProperty("java.version"));
    log.info("Java 的运行环境供应商："+props.getProperty("java.vendor"));
    log.info("Java 供应商的URL："+props.getProperty("java.vendor.url"));
    log.info("Java 的安装路径："+props.getProperty("java.home"));
    log.info("Java 的虚拟机规范版本："+props.getProperty("java.vm.specification.version"));
    log.info("Java 的虚拟机规范供应商："+props.getProperty("java.vm.specification.vendor"));
    log.info("Java 的虚拟机规范名称："+props.getProperty("java.vm.specification.name"));
    log.info("Java 的虚拟机实现版本："+props.getProperty("java.vm.version"));
    log.info("Java 的虚拟机实现供应商："+props.getProperty("java.vm.vendor"));
    log.info("Java 的虚拟机实现名称："+props.getProperty("java.vm.name"));
    log.info("Java 运行时环境规范版本："+props.getProperty("java.specification.version"));
    log.info("Java 运行时环境规范供应商："+props.getProperty("java.specification.vender"));
    log.info("Java 运行时环境规范名称："+props.getProperty("java.specification.name"));
    log.info("Java 的类格式版本号："+props.getProperty("java.class.version"));
    log.info("Java 的类路径："+props.getProperty("java.class.path"));
    log.info("加载库时搜索的路径列表："+props.getProperty("java.library.path"));
    log.info("默认的临时文件路径："+props.getProperty("java.io.tmpdir"));
    log.info("一个或多个扩展目录的路径："+props.getProperty("java.ext.dirs"));
  }


  // 正确的IP拿法，即优先拿site-local地址
  private static InetAddress getLocalHostLANAddress() throws UnknownHostException {
    try {
      InetAddress candidateAddress = null;
      // 遍历所有的网络接口
      for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements();) {
        NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
        // 在所有的接口下再遍历IP
        for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements();) {
          InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
          if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
            if (inetAddr.isSiteLocalAddress()) {
              // 如果是site-local地址，就是它了
              return inetAddr;
            } else if (candidateAddress == null) {
              // site-local类型的地址未被发现，先记录候选地址
              candidateAddress = inetAddr;
            }
          }
        }
      }
      if (candidateAddress != null) {
        return candidateAddress;
      }
      // 如果没有发现 non-loopback地址.只能用最次选的方案
      InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
      if (jdkSuppliedAddress == null) {
        throw new UnknownHostException("The JDK InetAddress.getLocalHost() method unexpectedly returned null.");
      }
      return jdkSuppliedAddress;
    } catch (Exception e) {
      UnknownHostException unknownHostException = new UnknownHostException(
          "Failed to determine LAN address: " + e);
      unknownHostException.initCause(e);
      throw unknownHostException;
    }
  }

  //出自这篇：http://www.cnblogs.com/zrui-xyu/p/5039551.html
  //实际上的代码是不准的
  private static InetAddress getLocalHostAddress() throws UnknownHostException {
    Enumeration allNetInterfaces;
    try {
      allNetInterfaces = NetworkInterface.getNetworkInterfaces();
      InetAddress ip = null;
      while (allNetInterfaces.hasMoreElements()) {
        NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();

        Enumeration addresses = netInterface.getInetAddresses();
        while (addresses.hasMoreElements()) {
          ip = (InetAddress) addresses.nextElement();
          if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
            if (ip != null && ip instanceof Inet4Address) {
              return ip;
            }
          }
        }
      }
    } catch (SocketException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
    if (jdkSuppliedAddress == null) {
      throw new UnknownHostException("The JDK InetAddress.getLocalHost() method unexpectedly returned null.");
    }
    return jdkSuppliedAddress;
  }

}
