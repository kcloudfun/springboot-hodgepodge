package com.record.hodgepodge.controller;

import com.record.hodgepodge.pojo.CommonResult;
import com.record.hodgepodge.service.IExcelHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ExcelHandleController {

    @Autowired
    private IExcelHandleService excelHandleService;

    public CommonResult<?> parseTemplateExcel(@RequestParam("excelFile") MultipartFile excelFile) throws IOException {
        return excelHandleService.parseExcel(excelFile);
    }
}
