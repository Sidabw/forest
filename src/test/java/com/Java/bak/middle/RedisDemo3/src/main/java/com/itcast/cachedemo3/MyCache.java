package com.Java.bak.middle.RedisDemo3.src.main.java.com.itcast.cachedemo3;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import com.itcast.cachedemo.Account;

public class MyCache implements Cache {

	private String name;
	private Map<String, Account> store = new HashMap<String, Account>();;

	public MyCache() {
	}

	public MyCache(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void evict(Object arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public ValueWrapper get(Object key) {
		ValueWrapper result = null;
		Account thevalue = store.get(key);
		if (thevalue != null) {
			thevalue.setPassword("from mycache:" + name);
			result = new SimpleValueWrapper(thevalue);
		}
		return result;
	}

	@Override
	public <T> T get(Object key, Class<T> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Object getNativeCache() {
		// TODO Auto-generated method stub
		return store;
	}

	@Override
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		Account thevalue = (Account) value;
		store.put((String) key, thevalue);

	}

	@Override
	public ValueWrapper putIfAbsent(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
