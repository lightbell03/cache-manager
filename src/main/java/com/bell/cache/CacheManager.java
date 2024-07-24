package com.bell.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager {

	private Map<String, CacheWrapper> cacheMap = new ConcurrentHashMap<>();

	public void setCache(List<CacheWrapper> cacheWrapperList) {
		for(CacheWrapper cacheWrapper : cacheWrapperList) {
			cacheMap.put(cacheWrapper.getName(), cacheWrapper);
		}
	}

	public Cache<Object, Object> getCache(String name) {
		CacheWrapper cacheWrapper = cacheMap.get(name);

		return cacheWrapper.getCache();
	}
}
