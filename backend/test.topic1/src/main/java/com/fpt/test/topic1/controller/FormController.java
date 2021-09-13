package com.fpt.test.topic1.controller;

import com.fpt.test.topic1.dto.FormDetailDTO;
import com.fpt.test.topic1.dto.FormValueDTO;
import com.fpt.test.topic1.dto.FormValueDetailDTO;
import com.fpt.test.topic1.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Admin
 * @created : 13-Aug-21
 **/
@RestController
@RequestMapping("/form")
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping("/scan")
    public List<FormDetailDTO> scanForm(@RequestParam("formName") String formName) {

        List<FormDetailDTO> formDetailDTOs = new ArrayList<>();
        formDetailDTOs = formService.scanForm(formName);

        return formDetailDTOs;
    }

    @PostMapping("value/add")
    public FormValueDTO addFormValue(@RequestBody FormValueDTO formValueDTO) {

        formService.addFormValue(formValueDTO);

        return formValueDTO;
    }
}
