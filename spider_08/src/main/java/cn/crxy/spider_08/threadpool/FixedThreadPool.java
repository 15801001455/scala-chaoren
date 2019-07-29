package cn.crxy.spider_08.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.crxy.spider_08.utils.Config;

public class FixedThreadPool implements ThreadPool {
	ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(Config.nThread);
	@Override
	public void execute(Runnable runnable) {
		newFixedThreadPool.execute(runnable);
	}

}
