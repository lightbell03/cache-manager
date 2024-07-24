package com.bell.cache.config;

import java.util.ArrayList;
import java.util.List;

import com.bell.cache.CacheService;

public class CacheSetting {
	private List<String> cacheKeys = new ArrayList<>();
	private CacheService cacheService;

	public void addkeys(String... keys) {
		for(String key : keys) {
			cacheKeys.add(key);
		}
	}

	public List<String> getCacheKeys() {
		String o = cacheService.get("test", "test");
		return cacheKeys;
	}
}
