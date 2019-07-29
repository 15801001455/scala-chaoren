package cn.crxy.spider_08;

import java.util.ArrayList;
import java.util.List;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * 守护进程，需要一直运行 
 * update jyc 监控分布式的爬虫项目哪个挂了(爬虫项目在启动的时候会在zookeeper的spider目录下建立临时节点，如果爬虫项目挂了，则该临时节点会消失，这个类就是监控哪些临时节点消失了的)
 * update jyc 注意一下发现zk的临时节点消失的时候，这个Watcher不是立马能监控到的，会有延时的!
 * @author Administrator
 *
 */
public class SpiderWatcher implements Watcher {
	CuratorFramework client;
	List<String> children = new ArrayList<String>();
	public SpiderWatcher() {
		String connectString = "192.168.1.170:2181";
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		client = CuratorFrameworkFactory.newClient(connectString, retryPolicy);
		client.start();
		
		try {
			children = client.getChildren().usingWatcher(this).forPath("/spider");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	@Override
	public void process(WatchedEvent event) {
		try {
			//update jyc 19/7/29 注意这行代码非常重要，zk的watcher只会监听一次，所以每次有事件发生变化(会自动进入process方法)，要重新监听目录
			List<String> newChildren = client.getChildren().usingWatcher(this).forPath("/spider");
			for (String ip : children) {
				if(!newChildren.contains(ip)){
					System.out.println("消失的节点IP："+ip);
					//TODO  给管理员发发送邮件或者短信 发邮件的话可以使用javamail 发短信的话可以使用第三方服务，例如：云片
				}
			}
			
			for (String ip : newChildren) {
				if(!children.contains(ip)){
					System.out.println("新增的节点IP："+ip);
				}
			}
			//这一行代码非常和重要
			this.children = newChildren;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		SpiderWatcher spiderWatcher = new SpiderWatcher();
		spiderWatcher.run();
	}


	private void run() {
		while(true){
			;
		}
	}
	
	
	
	

}
