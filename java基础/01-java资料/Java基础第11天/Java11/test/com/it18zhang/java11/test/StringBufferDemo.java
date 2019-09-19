package com.it18zhang.java11.test;

import org.junit.Test;

public class StringBufferDemo {
	@Test
	public void test1(){
		//�̰߳�ȫ
		StringBuffer buffer = new StringBuffer();
		buffer.append("abc");
		buffer.append("def");
		buffer.append("������");
		System.out.println(buffer.toString());
		
		//builder,���������ģʽ
		//��ʽ����
		StringBuilder builder = new StringBuilder();
		builder.append("abc")
			.append("def")
			.append("������")
			.insert(0, "hello");
		builder.delete(0, builder.length()-1);
		System.out.println(builder.toString());
	}
}
