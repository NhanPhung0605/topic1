package com.fpt.test.topic1.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : Admin
 * @created : 11-Aug-21
 **/
@Getter
@Setter
public class FormValueImageDTO {

    private Long formValueImageId;

    private Long formValueId;

    private String imagePath;

    private String fileName;
}
