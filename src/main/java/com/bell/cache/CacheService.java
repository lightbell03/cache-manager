package com.bell.cache;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CacheService {
	private final CacheManager cacheManager;

	public <K, T> T get(String cacheName, K key) {
		Cache<Object, Object> cache = cacheManager.getCache(cacheName);
		Object item = cache.getItem(key);
		try {
			return (T)item;
		} catch (ClassCastException e) {
			throw new RuntimeException("casting exception");
		}
	}

	public <K, T> void save(String cacheName, K key, T value) {
		Cache<Object, Object> cache = cacheManager.getCache(cacheName);
		cache.setItem(key, value);
	}
}
