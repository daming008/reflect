package com.dm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{
	void info();
	
	void fly();
}

class SuperMan implements Human{

	@Override
	public void info() {
		System.out.println("我是超人");
	}

	@Override
	public void fly() {
		System.out.println("我飞~~~");
	}
}

class MyInvocationHandler2 implements InvocationHandler{
	Object obj;
	public void setObject(Object obj){
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		HumanUtil h = new HumanUtil();
		h.method1();
		Object returnVal = method.invoke(obj, args);
		h.method2();
		return returnVal;
	}
}

class HumanUtil{
	public void method1(){
		System.out.println("方法一");
	}
	public void method2(){
		System.out.println("方法二");
	}
}

class MyProxy{
	//创建代理类对象
	public static Object getProxy(Object obj){
		MyInvocationHandler2 hand = new MyInvocationHandler2();
		hand.setObject(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), hand);
	}
}
public class TestAOP {
	public static void main(String[] args) {
		SuperMan man = new SuperMan();
		Object obj = MyProxy.getProxy(man);
		Human human = (Human)obj;
		human.fly();
		System.out.println();
		human.info();
		
		NickClothFactory nick = new NickClothFactory();
		Object obj2  = MyProxy.getProxy(nick);
		ClothFactory fa = (ClothFactory)obj2;
		fa.productCloth();
		
	}
}
