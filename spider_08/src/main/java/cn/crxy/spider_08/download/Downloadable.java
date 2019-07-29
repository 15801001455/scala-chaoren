package cn.crxy.spider_08.download;

import cn.crxy.spider_08.domain.Page;


public interface Downloadable {
	/**
	 * 下载url
	 * @param url
	 * @return
	 */
	 Page download(String url);
	
}
