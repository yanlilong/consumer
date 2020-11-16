package com.yanlilong.downloads;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class DownloadsServiceTest {

  DownloadsService downloadsService;

  @Before
  public void init() {
    downloadsService = new DownloadsService();
  }

  @Test
  public void createDownloadsZip() {

  }

  @Test
  public void createDownloadZipFiles() throws IOException {
    File zipFile = new File("null");

    File downloadFile1 = new File("testdata/downloadsfiles/regenbogen-4-farbig.pdf");
    File downloadFile2 = new File("testdata/downloadsfiles/bauernhof-esel.pdf");
    File downloadFile3 = new File(
        "testdata/downloadsfiles/confluent-kafka-definitive-guide-complete.pdf");
    File downloadFile4 = new File("testdata/downloadsfiles/its-a-match.pdf");
    File downloadFile5 = new File("testdata/downloadsfiles/Retoure_A14033328337.pdf");
    File downloadFile6 = new File("testdata/downloadsfiles/zahl-3.pdf");
    File downloadFile7 = new File("testdata/downloadsfiles/zahl-5.pdf");
    File downloadFile8 = new File("testdata/downloadsfiles/Zahlen-Lernen-13.pdf");
    File[] array = {downloadFile1, downloadFile2, downloadFile3, downloadFile4, downloadFile5,
        downloadFile6, downloadFile7, downloadFile8};
    downloadsService.createDownloadZipFiles(zipFile.getName(), Arrays.asList(array));
    assertEquals(true, zipFile.exists());
    ZipFile zipFile1 = new ZipFile(zipFile);
    Enumeration<ZipEntry> en = (Enumeration<ZipEntry>) zipFile1.entries();
    while (en.hasMoreElements()) {
      ZipEntry zipEntry = en.nextElement();
      log.info(zipEntry.getName());

    }

    //assertEquals("regenbogen-4-farbig.pdf",zipdownloadFiles.getEntry("regenbogen-4-farbig.pdf").getName());
    //assertEquals("zahl-5.pdf",zipdownloadFiles.getEntry("zahl-5.pdf").getName());
  }

  @Test
  public void getDownloadsZip() {
  }

  @Test
  public void deleteDownloadsZip() {
  }
}