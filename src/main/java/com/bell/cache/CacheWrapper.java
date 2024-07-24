package com.bell.cache;

public class CacheWrapper {
	private String name;
	private Cache<Object, Object> cache;

	public CacheWrapper(String name, Cache<Object, Object> cache) {
		this.name = name;
		this.cache = cache;
	}

	public String getName() {
		return name;
	}

	public Cache<Object, Object> getCache() {
		return cache;
	}
}
