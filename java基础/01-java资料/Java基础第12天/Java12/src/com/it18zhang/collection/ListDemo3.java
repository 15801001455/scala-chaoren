package com.it18zhang.collection;
import java.util.ArrayList;
import java.util.List;
/**
 * 测试List2
 */
public class ListDemo3 {
	public static void main(String[] args) {
		List<Cat> list = new ArrayList<Cat>();
		long start = System.currentTimeMillis() ;
		for(int i = 0 ; i < 10000000 ; i ++){
			list.add(new Cat("tom" + i, i));
		}
		System.out.println("put : " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis() ;
		//遍历集合
		Cat cat = null ;
		for(int i = 0 ; i < 100000000 ; i ++){
			cat = list.get(i % 1000000);
		}
		System.out.println("get : " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis() ;
		//遍历集合
		for(int i = 0 ; i < 100000000 ; i ++){
			Cat cat0 = list.get(i % 1000000);
		}
		System.out.println("get : " + (System.currentTimeMillis() - start));
	}
}
