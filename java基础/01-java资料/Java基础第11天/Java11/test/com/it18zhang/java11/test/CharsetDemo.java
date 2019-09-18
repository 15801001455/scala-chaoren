package com.it18zhang.java11.test;
import java.nio.charset.Charset;

import org.junit.Test;
/**
 * 字符集
 * @Test 注解
 */
public class CharsetDemo {
	@Test
	public void test1(){
		Charset charset = Charset.defaultCharset();
		System.out.println(charset.name());
		
		String s = "abc";
		byte[] bytes = s.getBytes();
		System.out.println(bytes.length);
	}
}
