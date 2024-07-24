package com.bell.cache.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bell.cache.Cache;
import com.bell.cache.CacheManager;
import com.bell.cache.CacheWrapper;
import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
public class CacheConfig {
	@Bean
	public CacheManager cacheManager() {
		List<CacheWrapper> list = new ArrayList<>();

		list.add(new CacheWrapper("test", Cache.cacheBuilder().build()));
		CacheManager cacheManager = new CacheManager();
		cacheManager.setCache(list);

		return null;
	}

}
