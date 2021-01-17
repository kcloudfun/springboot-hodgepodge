package com.record.hodgepodge.service;

import com.record.hodgepodge.pojo.CommonResult;
import org.springframework.web.multipart.MultipartFile;

public interface IExcelHandleService {

    CommonResult<Boolean> parseExcel(MultipartFile excelFile);
}
