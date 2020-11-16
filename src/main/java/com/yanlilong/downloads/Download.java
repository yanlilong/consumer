package com.yanlilong.downloads;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Download {
  private long filesAdded;
  private long bytesAddes;
  private long totalFiles;
  private long totalBytes;
  private DownloadStatus.Status status;

}
