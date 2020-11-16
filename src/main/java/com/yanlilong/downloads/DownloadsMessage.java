package com.yanlilong.downloads;

import java.io.Serializable;
import lombok.Data;

@Data
public class DownloadsMessage implements Serializable {
  public enum DownloadsStatus{
    PENDING,
    IN_PROGRESS,
    DONE,
    MAX_CONTENT_SIZE_EXCEEDED,
    CANCELLED
  };
  private int filesAdded;
  private long bytesAdded;
  private long totalBytes;
  private String nodeId;
  private int totalFiles;
  private DownloadsStatus status;
}
