package com.yanlilong.cache;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Getter
@Setter
public class DefaultSimpleCache<K extends Serializable,V extends Object> implements SimpleCache<K,V> {
  private static final int DEFAULT_CAPACITY = Integer.MAX_VALUE;
  private Cache<K, AbstractMap.SimpleImmutableEntry<K,V>> cache;
  @Override
  public boolean contain(K key) {
    return false;
  }

  @Override
  public Collection<K> getKeys() {
    return null;
  }

  @Override
  public V getValue(K key) {
    return null;
  }

  @Override
  public void put(K key, V value) {

  }

  @Override
  public void remove(K key) {

  }

  @Override
  public void clear() {

  }
}
