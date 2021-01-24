package com.yanlilong.downloads;

import com.yanlilong.downloads.DownloadsMessage.DownloadsStatus;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
public class DownloadsService {

  public DownloadsStatus createDownloadsZip(List<String> downloadsNodesList) {
    if (downloadsNodesList != null && !downloadsNodesList.isEmpty()) {
      // downloadsNodesList.stream().forEach(downlodsNode -> downlodsNode);

    }

    DownloadsStatus downloadStatus = null;
    return downloadStatus;
  }

  public Download createDownloads(List<DownloadNodes> downloadNodesList) {
    //downloadNodesList.stream().forEach(downloadNodes -> );
    Download download = new Download();
    return download;
  }

  public void createDownloadZipFiles(String zipFileName, List<File> downloadsFilesList) {
//todo test zipfile name. if get a zipfile name, use zipfile. if don't get a zipfile name,give a default zipfilename
    if (StringUtils.isBlank(zipFileName)) {
      zipFileName = "downloadsFiles.zip";
    }
    if (downloadsFilesList != null && !downloadsFilesList.isEmpty()) {
      try (
          ZipOutputStream zipOutputStream = new ZipOutputStream(
              new FileOutputStream(new File(zipFileName)))
      ) {

        for (File file : downloadsFilesList) {
          FileInputStream fileInputStream = new FileInputStream(file);
          ZipEntry zipEntry = new ZipEntry(file.getName());
          zipOutputStream.putNextEntry(zipEntry);
          int len;
          byte[] buffer = new byte[1024];
          while ((len = fileInputStream.read(buffer)) > 0) {
            zipOutputStream.write(buffer, 0, len);
          }
          fileInputStream.close();
        }
      } catch (IOException e) {
        log.error("can not create zip file");
      }
    }

  }

  public DownloadsStatus getDownloadsZip(String downloadNodeId) {
    DownloadsStatus downloadStatus = null;
    return downloadStatus;
  }

  public void deleteDownloadsZip(String downloadNodeId) {

  }
  /** private validationNodes(List<String> downloadsNodesList){
   if(CollectionUtils.isEmpty(downloadsNodesList)){
   throw new InvalidArgumentException(""+"");
   }*/

}

