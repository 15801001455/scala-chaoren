package cn.crxy.spider_08.download;

import cn.crxy.spider_08.domain.Page;
import cn.crxy.spider_08.utils.PageUtils;

public class HttpClientDownload implements Downloadable {

	@Override
	public Page download(String url) {
		Page page = new Page();
		String content = PageUtils.getContent(url);
		page.setContent(content);
		page.setUrl(url);
		return page;
	}

	

}
