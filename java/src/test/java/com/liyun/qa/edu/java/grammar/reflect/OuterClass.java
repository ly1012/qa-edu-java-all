package com.liyun.qa.edu.java.grammar.reflect;

public class OuterClass {

	static {
		System.out.println("【OuterClass】静态代码块");
	}
	
	public OuterClass(){
		System.out.println("【OuterClass】无参构造器");
	}

	public static class InnerClass extends OuterClass {

		public InnerClass(String m1, String m2){
			System.out.println("【InnerClass】构造器参数：\t"+m1+"\t"+m2);
		}

		public static void print(){
			System.out.println("【InnerClass】静态方法");
		}

	}
}
