package com.dm.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {
	@Test
	public void test1(){
		
		Class clazz = Person.class;
		//1.getFields获取运行时类及其父类声明为Public的属性
		Field[] field = clazz.getFields();
		for(Field f : field){
			System.out.println(f);
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!");
		
		//2.getDeclaredFields：获取运行时类本身所有属性
		Field[] field1 = clazz.getDeclaredFields();
		for(Field f : field1){
			int i =f.getModifiers();
			String string = Modifier.toString(i);
			System.out.print(string+ " ");
			System.out.print(f.getName());
			System.out.println();
		}
	}
}
