package com.dm.reflect;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;

public class TestReflection {
	
	@Test
	public void test4() throws Exception{
		Class clazz = Person.class;
		ClassLoader classLoader = clazz.getClassLoader();
		System.out.println(classLoader);
		
		String className="java.lang.Object";
		Class clazz2 = Class.forName(className);
		ClassLoader classLoader2 = clazz2.getClassLoader();
		System.out.println(classLoader2);
		
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("com\\dm\\reflect\\jdbc.properties");
		Properties properties = new Properties();
		properties.load(is);
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		System.out.println(user+"::"+password);
		
	}
	
	@Test
	public void test3() throws ClassNotFoundException{
		String className = "com.dm.reflect.Person";
		Class clazz = Class.forName(className);
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class clazz2 = classLoader.loadClass(className);
		System.out.println(clazz2);
	}
	@Test
	public void test2() throws Exception {
		Class clazz = Person.class;
		System.out.println(clazz);
		Person p = (Person) clazz.newInstance();
		Field f1 = clazz.getField("name");
		f1.set(p, "LIUDEHUA");
		System.out.println(p);
		
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);
		f2.set(p, 20);
		System.out.println(p);
		
		Method method = clazz.getMethod("display",String.class);
		method.invoke(p,"China");
		System.out.println(method);
	}
}
