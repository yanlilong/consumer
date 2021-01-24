package com.yanlilong.cache;

import java.io.Serializable;

public interface CacheFactory<K extends Serializable, V> {

  SimpleCache<K, V> createCache(String cacheName);

}
