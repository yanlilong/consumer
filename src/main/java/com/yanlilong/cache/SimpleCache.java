package com.yanlilong.cache;


import java.io.Serializable;
import java.util.Collection;

public interface SimpleCache<K extends Serializable, V extends Object> {

  public boolean contain(K key);

  public Collection<K> getKeys();

  public V getValue(K key);

  public void put(K key, V value);

  public void remove(K key);

  public void clear();

}

