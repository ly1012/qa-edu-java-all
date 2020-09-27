package com.liyun.qa.edu.java_algorithms.interview;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 问题4：解析json为kv形式，{"a":"1","b":{"c":"2"},"d":[{"e":"3"}]}，
 * 例如json数据，得到所有key和value的对应关系，例如array("a"=>1,"b.c"=>2,"d.0.e"=>3)
 *
 * @author Li Yun
 * @date 2020/8/14 14:07
 */
public class JsonKeyValueMap {

  Map<String, Object> map = new HashMap<>();

  @Test(description = "使用递归", dataProvider = "dp")
  public void test(Object input){
    getKeyValue(input, "");
    System.out.println(map);
  }

  @DataProvider(name = "dp")
  public Object[][] dp(){
    return new Object[][]{
        {JSONObject.parse("{\"a\":\"1\",\"b\":{\"c\":\"2\"},\"d\":[{\"e\":\"3\"},{\"f\":\"4\"}]}")}
    };
  }

  private void getKeyValue(Object input, String prefixKey){
    if(input instanceof Map){
      for (String key : ((Map<String, Object>)input).keySet()){
          if (!(((Map<String, Object>) input).get(key) instanceof Map
              || ((Map<String, Object>) input).get(key) instanceof List)){
            map.put(prefixKey + key, ((Map<String, Object>) input).get(key));
          }else {
            getKeyValue(((Map<String, Object>) input).get(key), prefixKey + key + ".");
          }
      }
    }else if(input instanceof List){
      for (int i = 0; i < ((List) input).size(); i++){
        getKeyValue(((List) input).get(i), prefixKey + i + ".");
      }
    }
  }

}
