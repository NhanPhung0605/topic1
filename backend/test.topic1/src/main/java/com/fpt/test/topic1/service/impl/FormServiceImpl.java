package com.fpt.test.topic1.service.impl;

import com.fpt.test.topic1.constant.EnumConstant;
import com.fpt.test.topic1.dto.*;
import com.fpt.test.topic1.entity.*;
import com.fpt.test.topic1.repository.FormDetailRepository;
import com.fpt.test.topic1.repository.FormRepository;
import com.fpt.test.topic1.repository.FormValueImageRepository;
import com.fpt.test.topic1.repository.FormValueRepository;
import com.fpt.test.topic1.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author : Admin
 * @created : 13-Aug-21
 **/
@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormDetailRepository formDetailRepository;

    @Autowired
    private FormValueRepository formValueRepository;

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private FormValueImageRepository formValueImageRepository;

    @Override
    public List<FormDetailDTO> scanForm(String formName) {
        List<FormDetailDTO> formDetailDTOs = new ArrayList<>();
        List<FormDetailEntity> formDetailEntities = formDetailRepository.getFormDetailByFormName(formName);

        if (!CollectionUtils.isEmpty(formDetailEntities)) {
            for (FormDetailEntity formDetailEntity : formDetailEntities) {
                FormDetailDTO formDetailDTO = new FormDetailDTO();
                formDetailDTO.setFormId(formDetailEntity.getFormEntity().getFormId());
                formDetailDTO.setFormDetailId(formDetailEntity.getFormDetailId());
                formDetailDTO.setFieldName(formDetailEntity.getFieldName());
                formDetailDTO.setFieldType(EnumConstant.fieldType.getEnumFieldTypeByType(formDetailEntity.getFieldType()).getValue());
                formDetailDTOs.add(formDetailDTO);
            }
        }

        return formDetailDTOs;
    }

    @Override
    public FormValueDTO addFormValue(FormValueDTO formValueDTO) {
        FormValueEntity formValueEntity = new FormValueEntity();
        formValueEntity.setCreatedDate(new Date());

        FormEntity formEntity = formRepository.getById(formValueDTO.getFormId());

        formValueEntity.setFormEntity(formEntity);

        if (!CollectionUtils.isEmpty(formValueDTO.getFormValueDetailDTOs())) {
            Set<FormValueDetailEntity> formValueDetailEntities = new HashSet<>();
            List<FormDetailEntity> formDetailEntities = formDetailRepository.getFormDetailByFormId(formValueDTO.getFormId());

            Map<Long, FormDetailEntity> formDetailEntityMap = new HashMap<>();
            if (!CollectionUtils.isEmpty(formDetailEntities)) {
                for (FormDetailEntity formDetailEntity : formDetailEntities) {
                    formDetailEntityMap.put(formDetailEntity.getFormDetailId(), formDetailEntity);
                }
            }
            for (FormValueDetailDTO formValueDetailDTO : formValueDTO.getFormValueDetailDTOs()) {

                FormValueDetailEntity formValueDetailEntity = new FormValueDetailEntity();
                formValueDetailEntity.setValueNum(formValueDetailDTO.getValueNum());
                formValueDetailEntity.setValueBool(formValueDetailDTO.getValueBool());
                FormDetailEntity formDetailEntity = formDetailEntityMap.get(formValueDetailDTO.getFormDetailId());
                if (formDetailEntity != null) {
                    formValueDetailEntity.setFormDetailEntity(formDetailEntity);
                }
                formValueDetailEntity.setFormValueEntity(formValueEntity);
                formValueDetailEntities.add(formValueDetailEntity);

            }
            formValueEntity.setFormValueDetailEntities(formValueDetailEntities);
        }

        if (!CollectionUtils.isEmpty(formValueDTO.getFormValueImageDTOs())) {
            Set<FormValueImageEntity> formValueImageEntities = new HashSet<>();
            for (FormValueImageDTO formValueImageDTO : formValueDTO.getFormValueImageDTOs()) {
                FormValueImageEntity formValueImageEntity = formValueImageRepository.getById(formValueImageDTO.getFormValueImageId());
                formValueImageEntity.setFormValueEntity(formValueEntity);
                formValueImageEntities.add(formValueImageEntity);
            }
            formValueEntity.setFormValueImageEntities(formValueImageEntities);
        }

        formValueRepository.save(formValueEntity);

        return formValueDTO;
    }

    @Override
    public List<FormValueImageDTO> insertImageToUploadFile(List<UploadFileDTO> uploadFileDTOS) {
        List<FormValueImageDTO> formValueImageDTOs = new ArrayList<>();
        if (!CollectionUtils.isEmpty(uploadFileDTOS)) {
            for (UploadFileDTO uploadFileDTO : uploadFileDTOS) {
                FormValueImageEntity formValueImageEntity = new FormValueImageEntity();
                formValueImageEntity.setImagePath(uploadFileDTO.getImagePath());
                formValueImageRepository.save(formValueImageEntity);

                FormValueImageDTO formValueImageDTO = new FormValueImageDTO();
                formValueImageDTO.setImagePath(uploadFileDTO.getImagePath());
                formValueImageDTO.setFileName(uploadFileDTO.getFileName());
                formValueImageDTO.setFormValueImageId(formValueImageEntity.getFormValueImageId());
                formValueImageDTOs.add(formValueImageDTO);
            }
        }
        return formValueImageDTOs;
    }

}
