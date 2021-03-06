package com.it18zhang.java14.stream;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.junit.Test;

public class TestStream {
	
	/**
	 * 标准输出,显示器(console)
	 */
	@Test
	public void testSystemOut() throws Exception{
		System.setOut(new PrintStream(new FileOutputStream("d:/arch/a.txt")));
		System.out.println("helloworldxxxxxxxxxxxx");
	}
	
	/**
	 * 标准输入(键盘)
	 */
	@Test
	public void testSystemIn() throws Exception{
		InputStream in = System.in ;
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null ;
		while((line = br.readLine()) != null){
			if(line.equals("quit")){
				System.exit(-1);
			}
			System.out.println("hello : " + line);
		}
	}
}
 