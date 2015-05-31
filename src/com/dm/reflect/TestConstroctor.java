package com.dm.reflect;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class TestConstroctor {
	
	@Test
	public void test1() throws Exception{
		String className = "com.dm.reflect.Person";
		Class clazz = Class.forName(className);
		Constructor cons = clazz.getDeclaredConstructor(String.class,int.class);
		cons.setAccessible(true);
		Person p1 = (Person) cons.newInstance("LDM",25);
		System.out.println(p1);
		
	}
}
