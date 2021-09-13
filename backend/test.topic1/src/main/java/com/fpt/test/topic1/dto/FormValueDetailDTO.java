package com.fpt.test.topic1.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : Admin
 * @created : 13-Aug-21
 **/
@Getter
@Setter
public class FormValueDetailDTO {
    private Long formValueDetailId;
    private Long formValue;
    private Long formDetailId;
    private Long valueNum;
    private Boolean valueBool;
}
