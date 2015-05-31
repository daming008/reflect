package com.dm.proxy;
//接口
interface ClothFactory{
	void productCloth();
}
//被代理类
class NickClothFactory implements ClothFactory{

	@Override
	public void productCloth() {
		System.out.println("Nick;;;;");
	}
	
}

//代理类
class ProxyFactory implements ClothFactory{
	ClothFactory cf ;
	public ProxyFactory(ClothFactory cf){
		this.cf = cf;
	}
	@Override
	public void productCloth() {
		System.out.println("代理类开始 代理啦");
		cf.productCloth();
	}
	
}
public class TestClothProduct {
	public static void main(String[] args) {
		NickClothFactory ncf = new NickClothFactory();
		ProxyFactory pf = new ProxyFactory(ncf);
		pf.productCloth();
		
	}
}
