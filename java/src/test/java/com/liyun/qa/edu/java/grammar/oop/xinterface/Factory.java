package com.liyun.qa.edu.java.grammar.oop.xinterface;

/**
 * 工厂
 * @date 2020/3/21 22:22
 * @author Li Yun
 */
public class Factory {

  /**
   * 制造物品
   * @param worker 工人
   */
  public void manufacture(Worker worker){
    worker.work();
  }

}
