package generic;

/**
 * Pair 泛型类 <br>
 * 创建时间：2020/3/8 11:41<br>
 * 作者：李云
 */
public class Pair<T> {

  private T first;
  private T second;

  public Pair(){
    first = null;
    second = null;
  }

  public Pair(T first, T second) {
    this.first = first;
    this.second = second;
  }

  public T getFirst() {
    return first;
  }

  public void setFirst(T first) {
    this.first = first;
  }

  public T getSecond() {
    return second;
  }

  public void setSecond(T second) {
    this.second = second;
  }

}
