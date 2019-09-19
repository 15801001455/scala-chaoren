package com.it18zhang.java12;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class PrimitiveDemo {

	public static void main(String[] args) {
		byte b = 127 ;
		short s = 12 ;
		int i = 100 ;
		long l = 1000L ;
		float f = (float)100.0;
		double d = 100.0;
		
		char c = ' ' ;
		boolean bb = false ;
		
		//包装类
		Byte b0 = new Byte("100") ;
		
		Short s0 = new Short((short)100) ;
		Integer i0 = new Integer(1000) ;
		Long l0 = new Long(1000); 
		Float f0 = null; 
		Double d0 = null ;
		Character c0 = null; 
		Boolean bb0 = null ;
		
		byte age = 123 ;
		age = (byte)0x123 ;
		age = -0x7f;
		System.out.println(age);
		
		int age0 = 255 ;
		System.out.println((byte)-age0);
		
		try{
			String ss = "abc" ;
			int r = new Integer(ss);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//自动装箱
	@Test
	public void testAutoBoxing(){
		int i = 100 ;
		int j = 200 ;
		int r = i + j ;
		
		Integer ii = new Integer(100);
		Integer jj = new Integer(200);
		
		Integer iii = 1000 ;				//自动装箱
		
		System.out.println(i + iii);		//自动拆箱
		
		List<Integer> list = new LinkedList<Integer>();
		list.add(new Integer(100));
		list.add(101);		//
		
		Integer ii0 = null ;
		System.out.println(100 + ii0);
	}
}
