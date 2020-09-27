package com.it18zhang.java25;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.junit.Test;

/**
 * 测试内省
 */
public class TestIntrospector {
	
	@Test
	public void test1() throws Exception{
		//得到bean信息
		BeanInfo bi = Introspector.getBeanInfo(Person.class);
		//得到属性描述符
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		//
		for(PropertyDescriptor pd : pds){
			//得到属性名
			System.out.println(pd.getName());
			//取得getXxx方法
			System.out.println(pd.getReadMethod());
			//取得setXxx方法
			System.out.println(pd.getWriteMethod());
		}
	}
}
