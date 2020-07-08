package grammar.generic;

/**
 * 员工实体类 <br>
 * 创建时间：2020/3/8 12:06<br>
 * 作者：李云
 */
public class Employee {

  private String name;
  private int age;

  public Employee(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
