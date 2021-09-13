package com.fpt.test.topic1.controller;

import com.fpt.test.topic1.dto.FormValueImageDTO;
import com.fpt.test.topic1.dto.UploadFileDTO;
import com.fpt.test.topic1.service.FormService;
import com.fpt.test.topic1.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Admin
 * @created : 11-Aug-21
 **/
@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private FormService formService;

    @PostMapping("/upload_file")
    public List<FormValueImageDTO> uploadFile(@RequestParam("file")MultipartFile[] files) {
        List<UploadFileDTO> uploadFileDTOs = new ArrayList<>();

        for (MultipartFile file : files) {
            uploadFileDTOs.add(uploadService.storeResourceToFile(file));
        }

        List<FormValueImageDTO> formValueImageDTOs = formService.insertImageToUploadFile(uploadFileDTOs);

        return formValueImageDTOs;
    }
}
