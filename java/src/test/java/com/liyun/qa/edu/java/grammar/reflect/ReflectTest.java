package com.liyun.qa.edu.java.grammar.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {

	public OuterClass.InnerClass sc;


	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

		System.out.println("-------------------------------------------");

		//TODO 为什么调用了外部类的无参构造器？
		new OuterClass.InnerClass("a1", "b1");

		System.out.println("-------------------------------------------");

		OuterClass.InnerClass.class.getConstructor(String.class, String.class).newInstance("a2", "b2");

		System.out.println("-------------------------------------------");

		ReflectTest tc = new ReflectTest();
		Field[] fields = tc.getClass().getFields();
		for(Field field : fields){
			boolean isAccessible = field.isAccessible();
			field.setAccessible(true); 							//设置些属性是可以访问的
			String exceptionMessage = "当前字段："+field.toString()+"\n";	
			Class<?> clazz = field.getType();
			Object value = null;
			try {
				Constructor<?> con = clazz.getConstructor(String.class,String.class);
				value = con.newInstance("a3","b3");
				field.set(tc, value);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				throw new RuntimeException(exceptionMessage,e);
			}
			field.setAccessible(isAccessible);
		}
	}

}
