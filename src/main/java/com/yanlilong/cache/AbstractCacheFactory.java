package com.yanlilong.cache;

import java.io.Serializable;
import java.util.Properties;

public abstract class AbstractCacheFactory<K extends Serializable, V extends Object> implements
    CacheFactory {

  private static final String PROP_SEPERATOR = ".";
  private Properties properties;

  public String getProperty(String cacheName, String propName, String defaultValue) {
    final String propertyKey = cacheName + PROP_SEPERATOR + propName;
    String propertyValue = properties.getProperty(propertyKey);
    if (propertyValue == null || propertyValue.isEmpty()) {
      return defaultValue;
    }

    return propertyValue.trim();
  }

  public void setProperties(Properties properties) {
    properties = properties;
  }

  ;
}
