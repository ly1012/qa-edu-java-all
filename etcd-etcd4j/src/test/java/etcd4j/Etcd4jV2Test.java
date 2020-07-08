package etcd4j;

import mousio.etcd4j.EtcdClient;
import mousio.etcd4j.responses.EtcdAuthenticationException;
import mousio.etcd4j.responses.EtcdException;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeoutException;

/**
 * Etcd4j 教学 <br>
 * 特别说明：必须调用 .send().get() ，命令才会真正执行。<br>
 * 创建时间：2019/3/25 16:02<br>
 * 作者：李云
 */
public class Etcd4jV2Test {

  EtcdClient client = new EtcdClient(URI.create("http://10.200.130.145:2379"));

  @Test
  public void testPutDir() throws IOException, EtcdAuthenticationException, TimeoutException, EtcdException {
    String dir = "/nginx/mocklab/xabank";
    client.putDir(dir).send().get();
  }


  @Test
  public void testPutKey() throws IOException, EtcdAuthenticationException, TimeoutException, EtcdException {
    String key = "/nginx/mocklab/t1_v/server1";
    String value = "{\"ip\":\"10.200.130.133\",\"port\":\"9002\"}";
    System.out.println(client.put(key,value).send().get().getNode().isDir());
    String str = client.get(key).send().get().getNode().getValue();
    Assert.assertEquals(value,str);
  }

  @Test
  public void testGetDir() throws IOException, EtcdAuthenticationException, TimeoutException, EtcdException {
    String value = client.getDir("/nginx/mocklab/ut_v").send().get().getNode().getValue();
    System.out.println(value);
  }

  @Test()
  public void testDeleteKey() {
    String key = "/nginx/mocklab/xabank1/online";
    try {
      client.delete(key).send().get();
      //String value = client.get(key).send().get().getNode().getValue();
    } catch (IOException e) {
      System.out.println("io");
      e.printStackTrace();
    } catch (EtcdException e) {
      System.out.println("etcd");
      System.out.println(e.getMessage());
      e.printStackTrace();
    } catch (EtcdAuthenticationException e) {
      System.out.println("etcdauth");
      e.printStackTrace();
    } catch (TimeoutException e) {
      System.out.println("timeout");
      e.printStackTrace();
    } catch (Exception e){
      System.out.println("grammar.exception");
    }
  }

  @Test()
  public void testDeleteDir() {
    String key = "/nginx";
    try {
      client.deleteDir(key).recursive().send().get();
      //String value = client.get(key).send().get().getNode().getValue();
    } catch (IOException e) {
      System.out.println("io");
      e.printStackTrace();
    } catch (EtcdException e) {
      System.out.println("etcd");
      e.printStackTrace();
    } catch (EtcdAuthenticationException e) {
      System.out.println("etcdauth");
      e.printStackTrace();
    } catch (TimeoutException e) {
      System.out.println("timeout");
      e.printStackTrace();
    }
  }

}
