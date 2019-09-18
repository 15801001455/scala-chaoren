package com.it18zhang.java11.test;

import org.junit.Test;

public class StringBufferDemo {
	@Test
	public void test1(){
		//线程安全
		StringBuffer buffer = new StringBuffer();
		buffer.append("abc");
		buffer.append("def");
		buffer.append("中若人");
		System.out.println(buffer.toString());
		
		//builder,构建器设计模式
		//链式编码
		StringBuilder builder = new StringBuilder();
		builder.append("abc")
			.append("def")
			.append("中若人")
			.insert(0, "hello");
		builder.delete(0, builder.length()-1);
		System.out.println(builder.toString());
	}
}
