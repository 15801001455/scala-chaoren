package 集合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * TestLinkedList
 */
public class TestLinkedList {
	@Test
	public void test1(){
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1, 5);//update jyc 这里容易理解错误 不会覆盖,插入元素后面的元素会后移
		System.out.println(list.size());
		System.out.println(list.toString());
	}
	
	/**
	 * 测试ArrayList和LinkedList性能比较
	 * update jyc ArrayList指定位置插入元素,需要后面的所有元素后移，效率非常低，这种场景更适合使用LinkedList
	 */
	@Test
	public void testWritePerformance(){
		int max = 1000000 ;
		//ArrayList
		List<Integer> list1 = new ArrayList<Integer>();
		long start = System.currentTimeMillis() ;
		for(int i = 0 ; i < max ; i ++){
			list1.add(0, i);
		}
		System.out.println(System.currentTimeMillis() - start);
		
		//LinkedList
		start = System.currentTimeMillis() ;
		List<Integer> list2 = new LinkedList<Integer>();
		for(int i = 0 ; i < max ; i ++){
			list2.add(0, i);
		}
		System.out.println(System.currentTimeMillis() - start);
	}
	
	/**
	 * 测试ArrayList和LinkedList性能比较
	 * update jyc 查询是ArrayList效率更高
	 */
	@Test
	public void testReadPerformance(){
		int max = 500000 ;
		//构造集合
		//ArrayList
		List<Integer> list1 = new ArrayList<Integer>();
		for(int i = 0 ; i < max ; i ++){
			list1.add(i);
		}
		
		//LinkedList
		List<Integer> list2 = new LinkedList<Integer>();
		for(int i = 0 ; i < max ; i ++){
			list2.add(i);
		}
		
		//ArrayList,查询指定位置的元素 效率高
		long start = System.nanoTime() ;
		list1.get(max / 2);
		System.out.println(System.nanoTime() - start);
		
		//LinkedList查询指定位置的元素 效率低
		start = System.nanoTime() ;
		list2.get(max / 2);
		System.out.println(System.nanoTime() - start);
	}
	
	/**
	 * 其他LinkedList方法
	 */
	@Test
	public void testOtherMethod(){
		List<String> list = new LinkedList<>();
		list.add(new String("tom"));
		list.add(new String("tomas"));
		list.add(new String("tomasLee"));
		list.add(new String("tomson"));
//		list.clear();		//清空集合
		System.out.println(list.size());
		
		//removeAll
		list.remove("tom");
		//list.remove(0);
		System.out.println(list.toString());
	}
}
