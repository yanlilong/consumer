package com.yanlilong.downloads;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadsController {
  @Autowired
  DownloadsService downloadsService;
  @PostMapping("/downloads")
  Download creatDownloads(@RequestBody List<DownloadNodes> downloadNodesList){
    List.of("1");
return downloadsService.createDownloads(downloadNodesList);
  }
}
