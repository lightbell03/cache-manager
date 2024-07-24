package com.bell.cache;

public class CacheItem<T> {
	private T item;
	private Long expireTime;

	public CacheItem(T item) {
		this.item = item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public T getItem() {
		return item;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}
}
