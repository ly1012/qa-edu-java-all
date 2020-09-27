package com.liyun.qa.edu.appium;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 *
 * @author Li Yun
 * @date 2020/8/13 16:48
 */
public class YamlReader {

  public static Account getAccount(String name){
    Yaml yaml = new Yaml();
    File file = new File("src/test/resources/account.yml");
    Map<String, Map<String,String>> map = null;
    try {
      map = yaml.load(new FileInputStream(file));
    } catch (FileNotFoundException fileNotFoundException) {
      throw new RuntimeException(fileNotFoundException);
    }
    Map<String,String> accountMap = map.get(name);
    Account account = new Account();
    account.setUsername(accountMap.get("username"));
    account.setPassword(accountMap.get("password"));
    return account;
  }


  public static class Account{

    private String username;
    private String password;

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

  }

}
