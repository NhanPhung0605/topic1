package com.fpt.test.topic1.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : Admin
 * @created : 13-Aug-21
 **/
@Getter
@Setter
public class FormDetailDTO {
    private Long formDetailId;
    private Long formId;
    private String fieldName;
    private String fieldType;
}
