package com.liyun.qa.edu.restassured.jsonpath;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * JsonPath 用法
 *
 * @author Li Yun
 * @date 2020/9/17 13:35
 */
public class JsonPathTest {

  private static final String JSON_STR = "{\n" +
      "\t\"count\": 20,\n" +
      "\t\"teams\": [{\n" +
      "\t\t\"id\": 322,\n" +
      "\t\t\"name\": \"Hull City FC\",\n" +
      "\t\t\"shortName\": \"Hull\",\n" +
      "\t\t\"squadMarketValue\": null,\n" +
      "\t\t\"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/a/a9/Hull_City_AFC.svg\"\n" +
      "\t}, {\n" +
      "\t\t\"id\": 338,\n" +
      "\t\t\"name\": \"Leicester City FC\",\n" +
      "\t\t\"shortName\": \"Foxes\",\n" +
      "\t\t\"squadMarketValue\": null,\n" +
      "\t\t\"crestUrl\": \"http://upload.wikimedia.org/wikipedia/en/6/63/Leicester02.png\"\n" +
      "\t}, {\n" +
      "\t\t\"id\": 340,\n" +
      "\t\t\"name\": \"Southampton FC\",\n" +
      "\t\t\"shortName\": \"Southampton\",\n" +
      "\t\t\"squadMarketValue\": null,\n" +
      "\t\t\"crestUrl\": \"http://upload.wikimedia.org/wikipedia/de/c/c9/FC_Southampton.svg\"\n" +
      "\t}]\n" +
      "}";

  // 原文标题：How to Effectively use Groovy GPath in REST Assured – Part 2: GPath JSON
  // 原文链接：https://www.colabug.com/114350.html
  @Test(description = "RestAssured 新版 JsonPath 使用 GPath")
  public void testJsonPath() {
    JsonPath response = JsonPath.from(JSON_STR);

    //Extract First or Last Value from Multiple Matches
    assertThat((String) response.get("teams.name[0]")).isEqualTo("Hull City FC");
    assertThat((String) response.get("teams.name[-1]")).isEqualTo("Southampton FC");

    //Extract All Values into a List
    ArrayList allTeamNames = response.get("teams.name");
    assertThat(allTeamNames.toString()).isEqualTo("[Hull City FC, Leicester City FC, Southampton FC]");

    //Extract Multiple Maps of Objects
    ArrayList<Map> allTeamData = response.get("teams");
    assertThat(allTeamData.size()).isEqualTo(3);
  }

}
