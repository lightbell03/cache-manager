package com.bell.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache<K extends Object, T extends Object> {
	private final Map<K, CacheItem<T>> itemMap;
	private Long expireTime;

	private Cache(int maxSize) {
		if (maxSize <= 0) {
			this.itemMap = new ConcurrentHashMap<>();
		} else {
			this.itemMap = new ConcurrentHashMap<>(maxSize);
		}
	}

	private void setExpireTime(long expireTime) {
		this.expireTime = expireTime;
	}

	public void setItem(K key, T item) {
		itemMap.put(key, new CacheItem<>(item));
	}

	public T getItem(K key) {
		CacheItem<T> item = itemMap.get(key);

		return item.getItem();
	}

	public static class CacheBuilder {
		private String defaultKey = "key";
		private long expireTime = 0;
		private int maxSize = 0;

		public CacheBuilder expireTime(long expireTime) {
			this.expireTime = expireTime;
			return this;
		}

		public CacheBuilder maxSize(int maxSize) {
			this.maxSize = maxSize;
			return this;
		}

		public Cache<Object, Object> build() {
			Cache<Object, Object> cache;
			cache = new Cache<>(maxSize);
			cache.setExpireTime(this.expireTime);
			return cache;
		}
	}

	public static CacheBuilder cacheBuilder() {
		return new CacheBuilder();
	}
}
