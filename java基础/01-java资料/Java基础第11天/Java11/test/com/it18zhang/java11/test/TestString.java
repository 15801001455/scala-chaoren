package com.it18zhang.java11.test;
import org.junit.Test;
/**
 * 娴嬭瘯String
 * @Test 娉ㄨВ
 */
public class TestString {
	/**
	 * 娴嬭瘯鏋勯�犲嚱鏁�
	 */
	@Test
	public void testStringConstr(){
		String s = new String("hello");
		char[] arr = new char[]{'h','o','w','a','r','e','y','o','u'};
		//offset : 鍋忕Щ閲�  count:涓暟
		s = new String(arr,3,5);
		System.out.println(s);
		
		//鍒涘缓鍑犱釜瀵硅薄
		String ss = new String("www");
	}
	/**
	 * 闀垮害
	 */
	@Test
	public void testStringMothod(){
		String s = " wello world涓枃" ;
		int length = s.length();		//瀛楃涓查暱搴�
		System.out.println(length);
		char c = 'x' ;
		System.out.println((int)c);
		
		//System.out.println(s.charAt(80));	//鎸囧畾浣嶇疆鐨勫瓧绗�
		System.out.println(s.charAt(s.length() - 1));
		
		//
		int pos = s.indexOf('l');			//indexOf杩斿洖瀛楃鐨勪綅缃�
		System.out.println(pos);
		
		System.out.println(s.lastIndexOf('l'));	//鏈�鍚庝竴涓嚭鐜扮殑浣嶇疆
		//hello world涓枃
		System.out.println(s.substring(0, 4));	//
		System.out.println(s.substring(0, s.length()));	//
		
		System.out.println(s.endsWith("涓枃"));
		System.out.println(s.startsWith("wello"));
		String sss = "" ;
		System.out.println(sss.length());
		char[] arrr = sss.toCharArray();
		System.out.println(arrr.length);
		
		s = " \\r\\\\h\t";
		System.out.println(s.length());
		System.out.println(s.trim());
		
		s = "hello world" ;
		String[] arr = s.split("l");
		for(int i = 0 ; i < arr.length ; i ++){
			System.out.println(arr[i]);
		}
		System.out.println((int)'a');
	}
}
