package api;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import org.testng.annotations.Test;

import java.io.File;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;

/**
 * go-fastdfs api <br>
 * 创建时间：2019/9/25 14:15<br>
 * 作者：李云
 */
public class AdminAPI {

  private static final String ENDPOINT = "https://dfs.360fintime.cn/group1";
  private static final String UPLOAD = "/upload";
  private static final String LOGIN = "/admin/doLogin";
  private static final String DELETE = "/admin/file/deleteFile";
  private static final String LOGOUT = "/admin/logout";

  Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888));

  @Test(description = "上传文件")
  public void testUpload(){
    //文件地址
    ClassPathResource classPathResource = new ClassPathResource("nature-2.jpg");
    File file = new File(classPathResource.getAbsolutePath());
    //声明参数集合
    HashMap<String, Object> paramMap = new HashMap<>();
    //文件
    paramMap.put("file", file);
    //输出
    paramMap.put("output","json");
    //自定义路径
    paramMap.put("path","/test/liyun");
    //场景
    paramMap.put("scene","default");
    //上传
    String result= HttpUtil.post(ENDPOINT + UPLOAD, paramMap);
    //输出json结果
    Console.log(result);
    // {"url":"http://dfs.360fintime.cn/group1/test/liyun/nature-2.jpg","md5":"171d2131de35cae73671a2626006e3e4","path":"/group1/test/liyun/nature-2.jpg","domain":"http://dfs.360fintime.cn","scene":"default","size":802990,"mtime":1569392982,"scenes":"default","retmsg":"","retcode":0,"src":"/group1/test/liyun/nature-2.jpg"}
  }

  @Test(description = "下载文件")
  public void testDownload(){
    HttpUtil.downloadFile("http://dfs.360fintime.cn/group1/test/liyun/nature-2.jpg","E:\\inbox\\nature-2.jpg");
  }

  @Test
  public void testProxy(){
    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8888));
    String body = HttpRequest.get("https://www.baidu.com").setProxy(proxy).execute().body();
    Console.log(body);
  }

  @Test(description = "删除文件")
  public void testDelete(){

    // 管理员登录
    HashMap map = new HashMap();
    map.put("account","hzlyun");
    map.put("password","hzlyun");
    String JSESSIONID = HttpRequest.post(ENDPOINT + LOGIN).form(map).execute().getCookieValue("JSESSIONID");
    Console.log(JSESSIONID);

    // 调用删除接口
    HashMap delMap = new HashMap();
    delMap.put("md5","171d2131de35cae73671a2626006e3e4");
    String delBody = HttpRequest.post(ENDPOINT + DELETE)
        .header("Cookie","JSESSIONID="+JSESSIONID)
        .form(delMap).execute().body();
    Console.log(delBody);
    //String state = JSONUtil.parseObj(delBody).get("state").toString();

    // 管理员登出
    int status = HttpRequest.get(ENDPOINT + LOGOUT)
        .header("Cookie","JSESSIONID="+JSESSIONID).execute().getStatus();
    Console.log(status);

  }

}
