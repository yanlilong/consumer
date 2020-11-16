package com.yanlilong.downloads;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class DownloadStatus {
  public enum Status{
    PENDING,
    IN_PROGRESS,
    DONE,
    MAX_CONTENT_SIZE_EXCEEDED,
    CANCELLED
  }

}
