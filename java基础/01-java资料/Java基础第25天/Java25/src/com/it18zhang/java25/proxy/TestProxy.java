package com.it18zhang.java25.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

/**
 * 不改变源代码，还为类增加新功能。
 * jdk的动态代理。
 */
public class TestProxy {
	@Test
	public void test1(){
		
		//目标对象
		HelloWorldServiceImpl s = new HelloWorldServiceImpl();
		
		//调用处理器
		MyInvocationHandler h = new MyInvocationHandler(s);
		
		//接口列表
		Class[] clazzes = {HelloWorldService.class};
		
		//创建代理对象
		HelloWorldService hws = (HelloWorldService) Proxy
				.newProxyInstance(HelloWorldServiceImpl.class.getClassLoader(), clazzes, h);
		//访问代理的方法.
		hws.sayHello("tom");
	}

	//代理处理器
	class MyInvocationHandler implements InvocationHandler{
		//目标对象
		private Object target  ;
		public MyInvocationHandler(Object target){
			this.target = target ;
		}
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("hello---world");
			//调用目标对象的方法
			return method.invoke(target, args);
		}
	}
}
