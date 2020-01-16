package 集合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/**
 * hashmap
 */
public class TestMap {
	/**
	 * 
	 */
	@Test
	public void testPut(){
		//创建map集合
		Map<String, String> map = new HashMap<String,String>();
		map.put("key001", "tom");
		map.put("key001", "tomas");
		map.put("key002", "tomas");
		map.put("key003", "tomson");
		System.out.println(map.size());
	}
	
	/**
	 * map的get
	 */
	@Test
	public void testReadAccess(){
		//创建map集合
		Map<String, String> map = new HashMap<String,String>();
		map.put("key001", "tom");
		map.put("key001", "tomas");
		map.put("key002", "tomas");
		map.put("key003", "tomson");
		
		String value = map.get("key001");
		System.out.println(value);
	}
	
	
	/**
	 * map的遍历 Entry
	 */
	@Test
	public void testReadAccess2(){
		//创建map集合
		Map<String, String> map = new HashMap<String,String>();
		map.put("key001", "tom");
		map.put("key001", "tomas");
		map.put("key002", "tomas");
		map.put("key003", "tomson");
		
		Set<Entry<String,String>> entrySet = map.entrySet();
		Iterator<Entry<String,String>> it = entrySet.iterator();
		while(it.hasNext()){
			Entry<String,String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " = " + value );
		}
	}
	
	/**
	 * KeySet遍历
	 */
	@Test
	public void testReadAccess3(){
		//创建map集合
		Map<String, String> map = new HashMap<String,String>();
		map.put("key001", "tom");
		map.put("key001", "tomas");
		map.put("key002", "tomas");
		map.put("key003", "tomson");
		
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()){
			String key = it.next() ;
			String value = map.get(key);
			System.out.println(key + " = " + value );
		}
	}
	
	
	/**
	 * 测试ArrayList和LinkedList性能比较
	 */
	@Test
	public void testWritePerformance(){
		int max = 10000000;
		//ArrayList
		List<Integer> list1 = new ArrayList<>();
		long start = System.currentTimeMillis() ;
		for(int i = 0 ; i < max ; i ++){
			list1.add(i);
		}
		System.out.println("ArrayList : " + (System.currentTimeMillis() - start));
		list1 = null ;
		
		//LinkedList
		start = System.currentTimeMillis() ;
		List<Integer> list2 = new LinkedList<Integer>();
		for(int i = 0 ; i < max ; i ++){
			list2.add( i);
		}
		System.out.println("LinkedList : " + (System.currentTimeMillis() - start));
		list2 = null ;
		
		//
		Set<Integer> set = new HashSet<Integer>();
		start = System.currentTimeMillis() ;
		for(int i = 0 ; i < max ; i ++){
			set.add(i);
		}
		System.out.println("Set : " + (System.currentTimeMillis() - start));
		set = null ;
	}
	
	/**
	 * 测试ArrayList和LinkedList性能比较
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
		
		//ArrayList,查询指定位置的元素
		long start = System.nanoTime() ;
		list1.get(max / 2);
		System.out.println(System.nanoTime() - start);
		
		//LinkedList查询指定位置的元素
		start = System.nanoTime() ;
		list2.get(max / 2);
		System.out.println(System.nanoTime() - start);
	}


	@Test
	public void testNestedMap(){
		//  楼栋编号          单元编号
		Map<Integer,Map<String,List<String>>> allBuilding = new HashMap<>();
		for(int i = 1 ; i <= 10 ; i ++){
			//   单元编号         人员名单
			Map<String,List<String>> allCells = new HashMap<>();
			//5个单元
			for(int j = 1 ; j <= 5 ; j ++){
				List<String> allNames = new ArrayList<String>();
				for(int k = 1 ; k <= 20 ; k ++){
					allNames.add("tom." + i + "." + j + "." + k);
				}
				allCells.put(i + "." + j, allNames);
			}
			allBuilding.put(i, allCells);
		}
		System.out.println("kk");
		Set<Entry<Integer,Map<String,List<String>>>> entries = allBuilding.entrySet();
		//迭代所有楼栋
		for(Iterator<Entry<Integer,Map<String,List<String>>>> it = entries.iterator(); it.hasNext() ; ){
			Entry<Integer,Map<String,List<String>>> e = it.next();
			Integer no = e.getKey();
			System.out.println(no + "栋=====>");
			Map<String,List<String>> value = e.getValue();
			Set<Entry<String,List<String>>> allCells0 =  value.entrySet();
			//迭代所有单元
			for(Iterator<Entry<String,List<String>>> itt = allCells0.iterator() ; itt.hasNext() ; ){
				Entry<String,List<String>> ee = itt.next();
				String cellNo =  ee.getKey();
				System.out.println(no + "栋=====>" + cellNo + "单元====>");
				List<String> allPeople0 = ee.getValue();
				//迭代所有人名单
				for(int i = 0 ; i < allPeople0.size() ; i ++){
					System.out.println(allPeople0.get(i));
				}
			}
		}
	}
}
