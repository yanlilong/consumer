package com.yanlilong.cache;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

public class NullCache<K extends Serializable, V extends Object> implements SimpleCache<K, V> {

  private static final NullCache<Serializable, Object> INSTANCE = new NullCache<Serializable, Object>();

  public static final <K extends Serializable, V extends Object> NullCache<K, V> getInstance() {
    return (NullCache<K, V>) INSTANCE;
  }

  public NullCache() {
  }

  @Override
  public boolean contain(K key) {
    return false;
  }

  @Override
  public Collection<K> getKeys() {
    return Collections.<K>emptyList();
  }


  public V getValue(K key) {
    return null;
  }

  @Override
  public void put(K key, V value) {
return;
  }

  @Override
  public void remove(K key) {
    return;
  }

  @Override
  public void clear() {

  }
}
