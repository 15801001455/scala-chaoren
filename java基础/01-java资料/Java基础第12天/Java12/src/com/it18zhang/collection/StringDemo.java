package com.it18zhang.collection;

import org.junit.Test;

public class StringDemo {
	@Test
	public void testEquals(){
		String a = new String("abc");
		String b = new String("abc");
		System.out.println(a == b);		//==判断内存地址
		System.out.println(a.equals(b));
	}
}
