package com.fpt.test.topic1.service.impl;

import com.fpt.test.topic1.config.FileStorageProperties;
import com.fpt.test.topic1.dto.UploadFileDTO;
import com.fpt.test.topic1.exception.FileStorageException;
import com.fpt.test.topic1.service.UploadService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

/**
 * @author : Admin
 * @created : 12-Aug-21
 **/
@Service
public class UploadServiceImpl implements UploadService {

    @Value("${sub.folder}")
    private String subFolder;

    @Autowired
    private FileStorageProperties fileStorageProperties;

    private final String FOLDER_SEPARATOR = "/";

    @Override
    public UploadFileDTO storeResourceToFile(MultipartFile file) {
        UploadFileDTO uploadFileDTO = new UploadFileDTO();
        uploadFileDTO.setFileName(storeResource(file));

        StringBuilder urlPath = new StringBuilder(fileStorageProperties.getUrl());
        if (subFolder != null) {
            urlPath.append(FOLDER_SEPARATOR).append(subFolder);
        }
        uploadFileDTO.setImagePath(urlPath.append(FOLDER_SEPARATOR).append(uploadFileDTO.getFileName()).toString());

        return uploadFileDTO;
    }

    private String storeResource(MultipartFile file) {
        Path fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        if (subFolder != null) {
            fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir() + FOLDER_SEPARATOR + subFolder).toAbsolutePath().normalize();
        }
        if (!Files.exists(fileStorageLocation)) {
            try {
                Files.createDirectories(fileStorageLocation);
            } catch (Exception ex) {
                throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
            }
        }

        Date currentTime = new Date();
        StringBuilder fileName = new StringBuilder();
        fileName.append(StringUtils.cleanPath(FilenameUtils.getBaseName(file.getOriginalFilename())))
                .append("_")
                .append(currentTime.getTime())
                .append(".")
                .append(FilenameUtils.getExtension(file.getOriginalFilename()));

        //validate file name
        try {
            if (fileName.toString().contains("..") || fileName.toString().length() > 254) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            //copy file to local disk
            Path targetLocation = fileStorageLocation.resolve(fileName.toString());
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName.toString();
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }

    }
}
