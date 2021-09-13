package com.fpt.test.topic1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author : Admin
 * @created : 13-Aug-21
 **/
@Getter
@Setter
public class FormValueDTO {
    private Long formValueId;
    private Long formId;
    private Date createdDate;
    private List<FormValueDetailDTO> formValueDetailDTOs;
    private List<FormValueImageDTO> formValueImageDTOs;
}
