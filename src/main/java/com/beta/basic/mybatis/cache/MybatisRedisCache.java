package com.beta.basic.mybatis.cache;

import com.beta.basic.util.RedisUtil;
import com.beta.basic.util.SerializeUtil;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MybatisRedisCache implements Cache {
	private static Logger logger = LoggerFactory
			.getLogger(MybatisRedisCache.class);
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private String id;

	public MybatisRedisCache(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Cache instance requires an ID");
		}
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id" + id);
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public ReadWriteLock getReadWriteLock() {
		return this.readWriteLock;
	}

	public int getSize() {
		return Integer.valueOf(RedisUtil.getJedis().dbSize().toString())
				.intValue();
	}

	public Object getObject(Object key) {
		Object value = SerializeUtil.unserialize(RedisUtil.getJedis().get(
				SerializeUtil.serialize(key.toString())));
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>getObject:" + key + "=" + value);
		return value;
	}

	public void putObject(Object key, Object value) {
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>putObject:" + key + "=" + value);
		RedisUtil.getJedis().set(SerializeUtil.serialize(key.toString()),
				SerializeUtil.serialize(value));
	}

	public Object removeObject(Object key) {
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>removeObject:key=" + key);
		return RedisUtil.getJedis().expire(
				SerializeUtil.serialize(key.toString()), 0);
	}

	public void clear() {
		RedisUtil.getJedis().flushDB();
	}
}
