package com.it18zhang.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 测试List
 */
public class ListDemo {
	@Test
	public void testArrayList(){
		List<String> list = new ArrayList<String>();
		for(int i = 0 ; i < 11 ; i ++){
			list.add("tom" + i);
		}
		System.out.println(list.size());
		System.out.println(list.get(3));
		System.currentTimeMillis();
	}
}
