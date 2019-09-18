package com.it18zhang.java11;

public class StringDemo {
	public static void main(String[] args) {
		String str = "tom" ;
		for(int i = 0 ; i < 100 ; i ++){
			str = str + i ;
			System.out.println(str);
		}
	}
}
