package grammar.oop.xinterface;

/**
 * 矿工，工人的子类 <br>
 * @author Li Yun
 * @date 2020/3/22 10:55
 */
public class Miner implements Worker {

  @Override
  //实现接口中的 work 抽象方法
  public void work() {
    breathe();  //接口中的默认方法
    System.out.println("挖矿中...");
    breathe();  //接口中的默认方法
    Worker.eat("苹果"); //接口中的静态方法
    //Miner.eat("梨子");  //error，接口中的静态方法无法被继承
  }

}
