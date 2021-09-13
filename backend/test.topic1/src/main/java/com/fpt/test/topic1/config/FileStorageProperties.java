package com.fpt.test.topic1.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : Admin
 * @created : 12-Aug-21
 **/
@ConfigurationProperties(prefix = "file")
@Getter
@Setter
public class FileStorageProperties {

    private String url;

    private String uploadDir;
}
