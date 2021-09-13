package com.fpt.test.topic1.service;

import com.fpt.test.topic1.dto.FormDetailDTO;
import com.fpt.test.topic1.dto.FormValueDTO;
import com.fpt.test.topic1.dto.FormValueImageDTO;
import com.fpt.test.topic1.dto.UploadFileDTO;

import java.util.List;

/**
 * @author : Admin
 * @created : 13-Aug-21
 **/
public interface FormService {

    List<FormDetailDTO> scanForm(String formName);

    FormValueDTO addFormValue(FormValueDTO formValueDTO);

    List<FormValueImageDTO> insertImageToUploadFile(List<UploadFileDTO> uploadFileDTOS);
}
