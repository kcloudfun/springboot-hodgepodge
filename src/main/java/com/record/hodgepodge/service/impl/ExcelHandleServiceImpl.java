package com.record.hodgepodge.service.impl;

import com.record.hodgepodge.pojo.CommonResult;
import com.record.hodgepodge.service.IExcelHandleService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class ExcelHandleServiceImpl implements IExcelHandleService {


    @Override
    public CommonResult<Boolean> parseExcel(MultipartFile excelFile) {
        return null;
    }
}
