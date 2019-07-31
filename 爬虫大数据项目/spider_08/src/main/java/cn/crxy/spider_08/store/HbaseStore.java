package cn.crxy.spider_08.store;

import java.util.Map;

import cn.crxy.spider_08.domain.Page;
import cn.crxy.spider_08.utils.HbaseUtils;
import cn.crxy.spider_08.utils.RedisUtils;

public class HbaseStore implements Storeable {

	HbaseUtils hbaseUtils = new HbaseUtils();
	RedisUtils redisUtils = new RedisUtils();
	@Override
	public void store(Page page) {
		String goodsid = page.getGoodsid();
		//update jyc 整个项目原理就是先爬虫，然后存hbase，同时redis存商品id，然后有个web项目通过solr搜索商品 这个solr_index的key是给spider_web项目的SolrIndex项目用的
		redisUtils.add("solr_index", goodsid);
		Map<String, String> map = page.getMap();
		try{
			hbaseUtils.put(HbaseUtils.TABLE_NAME, goodsid, HbaseUtils.COLUMNFAMILY_1, HbaseUtils.COLUMNFAMILY_1_DATA_URL, page.getUrl());
			hbaseUtils.put(HbaseUtils.TABLE_NAME, goodsid, HbaseUtils.COLUMNFAMILY_1, HbaseUtils.COLUMNFAMILY_1_PIC_URL, map.get("picurl"));
			hbaseUtils.put(HbaseUtils.TABLE_NAME, goodsid, HbaseUtils.COLUMNFAMILY_1, HbaseUtils.COLUMNFAMILY_1_PRICE, map.get("price"));
			hbaseUtils.put(HbaseUtils.TABLE_NAME, goodsid, HbaseUtils.COLUMNFAMILY_1, HbaseUtils.COLUMNFAMILY_1_TITLE, map.get("title"));
			hbaseUtils.put(HbaseUtils.TABLE_NAME, goodsid, HbaseUtils.COLUMNFAMILY_2, HbaseUtils.COLUMNFAMILY_2_PARAM, map.get("spec"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
