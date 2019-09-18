package com.it18zhang.java11.test;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.junit.Test;
/**
 * 
 */
public class TestString2 {
	public static void main(String[] args) {
		//默认字符集
		Charset cs = Charset.defaultCharset();
		System.out.println(cs.name());
	}
	
	@Test
	public void test1() throws Exception{
		Charset cs = Charset.defaultCharset();
		System.out.println(cs.name());
		String s = "abc";
		//编码过程
		byte[] arr = s.getBytes("gbk");
		
		//解码
		String str2 = new String(arr, "gbk");
		System.out.println(str2);
		
		char c = '\u0061' ;
		System.out.println(c);
		s = "abc";
		
		//编码
		arr = s.getBytes("iso-8859-1");
		System.out.println(new String(arr,"gbk"));
	}
	
	@Test
	public void test2() throws Exception{
		String s = "abc中" ;
		byte[] arr = s.getBytes("utf-8");
		System.out.println(new String(arr,"utf-8"));
	}
}
