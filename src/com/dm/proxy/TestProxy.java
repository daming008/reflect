package com.dm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject{
	void action();
}
//被代理类
class RealSubject implements Subject{

	@Override
	public void action() {
		System.out.println("我是被代理类~~");
	}
	
}

class MyInvocationHandler implements InvocationHandler{
	Object obj;
	public Object blind(Object obj){
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(obj, args);
	}
	
}
public class TestProxy {
	public static void main(String[] args) {
		RealSubject rs = new RealSubject();
		MyInvocationHandler mi = new MyInvocationHandler();
		Object obj = mi.blind(rs);
		Subject sub = (Subject)obj;
		sub.action();
		
		NickClothFactory nick = new NickClothFactory();
		Object obj2 = mi.blind(nick);
		ClothFactory sub2 = (ClothFactory) obj2;
		sub2.productCloth();;
		
	}
}
