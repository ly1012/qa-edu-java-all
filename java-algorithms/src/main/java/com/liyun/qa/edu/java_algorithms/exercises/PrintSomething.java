package com.liyun.qa.edu.java_algorithms.exercises;

/**
 * 打印专题
 *
 * @author Li Yun
 * @date 2018/11/27 13:34
 */
public class PrintSomething {


  /**
   * 打印倒正三角形
   * @param edgeLength 正三角形的边长
   */
  public static void printInvertedTriangle(int edgeLength) {
    // 根据边长计算总行数
    for (int i = 1; i <= edgeLength; i++) {
      // 根据边长计算总列数
      for (int j = 1; j <= 2 * edgeLength - 1; j++) {
        // 计算每行实心的起始位置和结束位置
        if (j >= i && j <= 2 * edgeLength - i) {
          //if ((i%2 ==0 && j%2 ==0)||(i%2 == 1 && j%2 == 1)){ // 计算实心位置
          if ((i + j) % 2 == 0) { // 计算实心位置，代码优化
            System.out.print("*");
          } else { // 其他的就是空心
            System.out.print(" ");
          }
        } else { // 起始结束范围外的都是空心
          System.out.print(" ");
        }
      }
      // 每行结束换行
      System.out.println();
    }
  }

  /**
   * 打印倒正三角形
   * <p>思路：先输出空白，再输出剩余的星。记 ai 为第 i 行，则输出的空白数（列数） a1=0，a2=1，...，a8=7，
   * 即 ai=i-1=j，即 j < i 时输出空白，否则输出星。</p>
   * @param edgeLength 正三角形的边长
   */
  public static void printInvertedTriangle2(int edgeLength){
    for(int i = 1; i <= edgeLength; i++){ //行：使用for循环控制打印的行数
      for(int j = 1; j <= edgeLength; j++){ //列：使用for循环打印单行
        if(j < i){
          System.out.print('\0'); //单行中小于行数部分，输出空格。\0 表示空字符
        }else{
          System.out.print("*"+'\0');//大于行数部分，输出*+空格
        }
      }
      System.out.println();
    }
  }

}
