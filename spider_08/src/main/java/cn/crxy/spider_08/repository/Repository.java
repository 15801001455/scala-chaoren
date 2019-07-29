package cn.crxy.spider_08.repository;

public interface Repository {

	String poll();

	void add(String nexturl);

	void addHigh(String nexturl);

}
