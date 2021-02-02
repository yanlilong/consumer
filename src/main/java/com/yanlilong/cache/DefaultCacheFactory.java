package com.yanlilong.cache;

import java.io.Serializable;

public class DefaultCacheFactory<K extends Serializable, V> extends AbstractCacheFactory<K, V> {

  private static final String EVICT_NONE = "NONE";

  @Override
  public SimpleCache createCache(String cacheName) {
    return null;
  }

  private SimpleCache<K, V> createLocalCache(String cacheName) {
    int maxItems = maxItems(cacheName);
    boolean useMaxItems = useMaxItems(cacheName);
    int ttlSds = ttlSeconds(cacheName);
    int maxIdleSds = maxIdleSeconds(cacheName);
   return new DefaultSimpleCache<K,V>(maxItems,useMaxItems,ttlSds,maxIdleSds,cacheName);

    return null;
  }

  private int maxItems(String cacheName) {
    String maxItemsStr = getProperty(cacheName, "maxItems", "0");
    return Integer.parseInt(maxItemsStr);
  }

  private boolean useMaxItems(String cacheName) {
    String evictionPolicy = getProperty(cacheName, "eviction-policy", EVICT_NONE);
    if (evictionPolicy != null || !evictionPolicy.isEmpty()) {
      return !EVICT_NONE.equals(evictionPolicy.toUpperCase().trim());
    }
    return false;
  }

  /*timeToLiveSeconds – The maximum number of
  seconds an element can exist in the cache regardless of use.*/
  private int ttlSeconds(String cacheName) {
    String ttlSds = getProperty(cacheName, "timeToLIveSeconds", "0");
    return Integer.parseInt(ttlSds);
  }

  //The maximum number of seconds an element can exist in the cache without being accessed
  private int maxIdleSeconds(String cacheName) {
    String idleSds = getProperty(cacheName, "maxIdleSeconds", "0");
    return Integer.parseInt(idleSds);
  }

  public static void main(String[] args) {
    System.out.println(Integer.parseInt("2000", 10));
  }
}
