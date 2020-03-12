package topic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SwapTwoVariablesTest {

  @Test(dataProvider = "testcase")
  public void testByTempVar(SwapTwoVariables.Data data, int two, int one) {
    SwapTwoVariables.byTempVar(data);
    assertEquals(data.getOne(), two);
    assertEquals(data.getTwo(), one);
  }

  @Test(dataProvider = "testcase")
  public void testByAdditionOfVar(SwapTwoVariables.Data data,int two, int one) {
    SwapTwoVariables.byAdditionOfVar(data);
    assertEquals(data.getOne(), two);
    assertEquals(data.getTwo(), one);
  }

  @Test(dataProvider = "testcase")
  public void testBySubtractOfVar(SwapTwoVariables.Data data,int two, int one) {
    SwapTwoVariables.bySubtractOfVar(data);
    assertEquals(data.getOne(), two);
    assertEquals(data.getTwo(), one);
  }

  @Test(dataProvider = "testcase")
  public void testByAdditionOfVar2(SwapTwoVariables.Data data,int two, int one) {
    SwapTwoVariables.byAdditionOfVar2(data);
    assertEquals(data.getOne(), two);
    assertEquals(data.getTwo(), one);
  }

  @Test(dataProvider = "testcase")
  public void testByXOR(SwapTwoVariables.Data data,int two, int one) {
    SwapTwoVariables.byXOR(data);
    assertEquals(data.getOne(), two);
    assertEquals(data.getTwo(), one);
  }

  @DataProvider(name = "testcase")
  public Object[][] testcase(){
    SwapTwoVariables stv = new SwapTwoVariables();
    return new Object[][]{
        {stv.new Data(1,2), 2, 1},
        {stv.new Data(-2,-7), -7, -2},
        {stv.new Data(0,100), 100, 0},
        {stv.new Data(-9,8), 8, -9}
    };
  }
}