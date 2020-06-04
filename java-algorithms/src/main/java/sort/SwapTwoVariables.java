package sort;

/**
 * 交换两个变量的值。这里总结三个方法：临时变量、加减法、异或。 <br>
 * 创建时间：2020/3/6 13:23<br>
 * 作者：李云
 */
public class SwapTwoVariables {

  /**
   * 使用临时变量
   */
  public static void byTempVar(Data data){
    int a = data.getOne();
    int b = data.getTwo();

    // 交换变量，临时变量 c
    int c = a;
    a = b;
    b = c;

    data.setOne(a);
    data.setTwo(b);
  }

  /**
   * 通过变量相加
   */
  public static void byAdditionOfVar(Data data){
    int a = data.getOne();
    int b = data.getTwo();

    // 交换变量（加法求总和）
    a = a + b;
    b = a - b;
    a = a - b;

    data.setOne(a);
    data.setTwo(b);
  }

  /**
   * 通过变量相减
   */
  public static void bySubtractOfVar(Data data){
    int a = data.getOne();
    int b = data.getTwo();

    // 交换变量（减法取差值）
    a = a - b;
    b = a + b;
    a = b - a;

    data.setOne(a);
    data.setTwo(b);
  }

  /**
   * 通过变量相加，简化版
   */
  public static void byAdditionOfVar2(Data data){
    int a = data.getOne();
    int b = data.getTwo();

    // 交换变量
    b = (a + b) - (a = b);

    data.setOne(a);
    data.setTwo(b);
  }

  /**
   * 使用异或的特点：自反性
   *
   * 缺点：无法完成变量自交换
   */
  public static void byXOR(Data data){
    int a = data.getOne();
    int b = data.getTwo();

    // 交换变量
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;

    data.setOne(a);
    data.setTwo(b);
  }


  public class Data{
    public int one;
    public int two;

    public Data(int one, int two) {
      this.one = one;
      this.two = two;
    }

    public void setOne(int one) {
      this.one = one;
    }

    public void setTwo(int two) {
      this.two = two;
    }

    public int getOne() {
      return one;
    }

    public int getTwo() {
      return two;
    }
  }

}
