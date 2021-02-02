package com.yanlilong.cache;

public interface RefreshableCacheListener {
  public void onRefreshableCacheEvent(RefreshableCacheEvent event);
  public String getCacheId();

}
