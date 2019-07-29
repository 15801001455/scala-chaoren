package cn.crxy.spider_08.utils;

public class SleepUtils {
	
	public static void sleep(long million){
		try {
			Thread.sleep(million);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
