package com.yanlilong.cache;

import com.google.common.base.Objects;

public abstract class AbstractRefreshableCacheEvent implements RefreshableCacheEvent {

  private String cacheId;
  private String tenantId;

  AbstractRefreshableCacheEvent(String cacheId, String tenantId) {
    this.cacheId = cacheId;
    this.tenantId = tenantId;
  }

  @Override
  public String getCacheId() {
    return cacheId;
  }

  @Override
  public String getTenantId() {
    return tenantId;
  }
//todo
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractRefreshableCacheEvent that = (AbstractRefreshableCacheEvent) o;
    return Objects.equal(cacheId, that.cacheId) &&
        Objects.equal(tenantId, that.tenantId);
  }
//todo
  @Override
  public int hashCode() {
    return Objects.hashCode(cacheId, tenantId);
  }

  @Override
  public String toString() {
    return "AbstractRefreshableCacheEvent{" +
        "cacheId='" + cacheId + '\'' +
        ", tenantId='" + tenantId + '\'' +
        '}';
  }
}
