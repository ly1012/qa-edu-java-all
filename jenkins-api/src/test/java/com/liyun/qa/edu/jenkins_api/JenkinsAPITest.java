package com.liyun.qa.edu.jenkins_api;

import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

/**
 * Jenkins API
 * @date 2019/1/17 11:32
 * @author Li Yun
 */
public class JenkinsAPITest {


  @Test
  public void testGetBranch() {
    //baseURI = "http://10.200.167.10:58081/jenkins";
    authentication = preemptive().basic("xxx", "yyy");
    List<String> urls = get("http://127.0.0.1:58081/jenkins/job/release-job/api/json?pretty=true").
        then().log().all().
        extract().body().jsonPath().getList("jobs.url");

    for (String url : urls) {
      try{
        JsonPath jsonpath = get(url + "lastSuccessfulBuild/com.liyun.qa.edu.java.api/json?pretty=true").
            then().extract().body().jsonPath();
        String branchName = jsonpath.getString("actions[1].lastBuiltRevision.branch.name");
        System.out.println(url);
        System.out.println(branchName);
      }catch (JsonPathException e){
        System.out.println("Error: "+url);
      }
    }


  }

}
