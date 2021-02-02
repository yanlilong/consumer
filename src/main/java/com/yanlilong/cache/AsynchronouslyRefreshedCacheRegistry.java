package com.yanlilong.cache;

public interface AsynchronouslyRefreshedCacheRegistry {
  public void register(RefreshableCacheListener listener);
  public void broadcastEvent(RefreshableCacheEvent event, boolean toAll);

}
