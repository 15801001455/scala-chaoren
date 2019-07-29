package cn.crxy.spider_08;

import java.util.List;

import org.junit.Test;

import cn.crxy.spider_08.domain.Page;
import cn.crxy.spider_08.download.HttpClientDownload;
import cn.crxy.spider_08.process.JdProcess;
import cn.crxy.spider_08.store.ConsoleStore;
import cn.crxy.spider_08.store.HbaseStore;

public class SpiderTest {
	
	
	@Test
	public void test() throws Exception {
		Spider spider = new Spider();
		//spider.start();
		spider.setDownloadable(new HttpClientDownload());
		spider.setProcessable(new JdProcess());
		spider.setStoreable(new HbaseStore());
		
		String url = "http://list.jd.com/list.html?cat=9987,653,655";
		Page  page = spider.download(url);
		spider.process(page);
		List<String> urlList = page.getUrlList();
		System.out.println(urlList.size());
		spider.store(page);
		
	}

}
