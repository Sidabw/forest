package com.Java.bak.middle.RedisDemo3.src.main.java.com.itcast.cachedemo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyCacheManager<T> {
	//ConcurrentHashMap:支持获取的完全并发和更新的所期望可调整并发的哈希表
	private Map<String,T> cache =new ConcurrentHashMap<String,T>();
	
	public T getValue(Object key){
		return cache.get(key);
	}
	public void addOrUpdateCache(String key ,T value){
		cache.put(key, value);
	}
	public void evictCache(String key){// 根据 key 来删除缓存中的一条记录
		if(cache.containsKey(key)){
			cache.remove(key);
		}
	}
	public void evictCache(){
		cache.clear();
	}
}
