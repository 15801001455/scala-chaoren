package cn.crxy.spider_08.store;

import cn.crxy.spider_08.domain.Page;

public class ConsoleStore implements Storeable {

	@Override
	public void store(Page page) {
		System.out.println(page.getUrl()+"---"+page.getMap().get("price"));
	}

}
