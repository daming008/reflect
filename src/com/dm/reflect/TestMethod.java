package com.dm.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class TestMethod {
	
	@Test
	public void test3() throws Exception{
		Class clazz = Person.class;
		Method method = clazz.getDeclaredMethod("display",String.class);
		method.setAccessible(true);
		Person p = (Person) clazz.newInstance();
		Object obj = method.invoke(p, "Hello!");
		System.out.println(obj);
	}
	@Test
	public void test1(){
		Class clazz = Person.class;
		Method[] methods = clazz.getMethods();
		for(Method m : methods){
			System.out.println(m);
		}
	}
	
	@Test
	public void testOther2(){
		//获取父类的泛型
		Class clazz = Person.class;
		Type type = clazz.getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType)type;
		Type[] actualType = parameterizedType.getActualTypeArguments();
		System.out.println(actualType[0].toString());
		
	}
	
	@Test
	public void testOther(){
		Class clazz = Person.class;
		Class superclass = clazz.getSuperclass();
		System.out.println(superclass);
		Type genfeiSuperclass = clazz.getGenericSuperclass();
		System.out.println(genfeiSuperclass);
	}
}
