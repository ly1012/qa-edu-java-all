package generic;

/**
 * Pair 使用示例 <br>
 * 创建时间：2020/3/8 12:08<br>
 * 作者：李云
 */
public class PairExample {

  public static void main(String[] args) {
    Pair<Employee> buddies = new Pair<>(new Employee("马云",1), new Employee("曾明",2));
    Employee buddy = buddies.getFirst();
  }


}
