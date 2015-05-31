package com.dm.reflect;

@MyAnnotation("abc")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{
	public String name;
	private int age;
	int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person() {
		System.out.println("constrotor....");
	}
	public Person(String name) {
		super();
		this.name = name;
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@MyAnnotation(value="abcd")
	public void show(){
		System.out.println("我是一个人");
	}
	
	private String display(String nation) throws Exception{
		System.out.println("我的国籍是"+nation);
		return nation;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(String o) {
		return 0;
	}
	
	class Bird{
		
	}
	
}
