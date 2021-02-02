package com.yanlilong.cache;

public interface RefreshableCache <T>{
  public T get();
  public void refresh();

}
