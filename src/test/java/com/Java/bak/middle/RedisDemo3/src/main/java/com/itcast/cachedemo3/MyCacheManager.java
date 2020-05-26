package com.Java.bak.middle.RedisDemo3.src.main.java.com.itcast.cachedemo3;

import java.util.Collection;

import org.springframework.cache.support.AbstractCacheManager;

public class MyCacheManager extends AbstractCacheManager {
	private Collection<? extends MyCache> caches;

	/**
	 * Specify the collection of Cache instances to use for this CacheManager.
	 */
	public void setCaches(Collection<? extends MyCache> caches) {
		this.caches = caches;
	}

	@Override
	protected Collection<? extends MyCache> loadCaches() {
		// TODO Auto-generated method stub
		return this.caches;
	}

}
