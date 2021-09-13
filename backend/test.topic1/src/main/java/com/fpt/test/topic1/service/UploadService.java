package com.fpt.test.topic1.service;

import com.fpt.test.topic1.dto.UploadFileDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : Admin
 * @created : 12-Aug-21
 **/
public interface UploadService {

    UploadFileDTO storeResourceToFile(MultipartFile multipartFile) ;
}
