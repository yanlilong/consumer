package com.yanlilong.cache;

public interface AsynchronouslyRefreshedCache<T> extends RefreshableCache<T> {

  String getCacheId();

  boolean isUpToDate();

}
