package com.it18zhang.java11.test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * 测试GBK编码
 */
public class TestGBKEncode {
	public static void main(String[] args) throws Exception {
		char c = 97 ;
		c = '\u0061';
		int line = 80 ;
//		for(int i = 0 ; i < 0xffff ; i ++){
//			if( i % line == 0){
//				System.out.println();
//			}
//			System.out.print((char)i);
//		}
		
		String s = "abc�й�" ;
		byte[] arr = s.getBytes("gbk");
		System.out.println(arr.length);
		s = new String(arr,"gbk");
		
		arr = s.getBytes("utf-8");
		System.out.println(new String(arr,"gbk"));
		
		
		arr = s.getBytes("iso8859-1");
		System.out.println(new String(arr,"iso8859-1"));
		
		System.out.println((int)'?');
//		byte[] aaa = {-28,-72};
//		System.out.println(new String(aaa,"gbk"));
	}
}
