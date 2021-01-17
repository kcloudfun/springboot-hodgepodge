package com.record.hodgepodge.controller;

import com.record.hodgepodge.service.IFileHandleService;
import com.record.hodgepodge.pojo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileHandleController {

    @Autowired
    private IFileHandleService fileHandleService;

    /**
     * 文件上传（多个）：前台需使用form-data形式传参
     *
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/upload/batch")
    public CommonResult<List<String>> batchUpload(HttpServletRequest request) throws Exception {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("files");
        return fileHandleService.batchUpload(files);
    }

    /**
     * 文件上传（单个）：前台需使用form-data形式传参
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public CommonResult<String> upload(@RequestParam("file") MultipartFile file) throws Exception {
        return fileHandleService.upload(file);
    }

    /**
     * 根据文件编号下载已上传文件
     *
     * @param response
     * @param fileId
     */
    @PostMapping("/download/{fileId}")
    public void download(HttpServletResponse response, @PathVariable String fileId) {
        fileHandleService.download(response, fileId);
    }

    /**
     * 根据文件编号删除已上传文件
     *
     * @param fileId
     * @return
     */
    @PostMapping("/delete/{fileId}")
    public CommonResult<Boolean> deleteFile(@PathVariable String fileId) {
        return fileHandleService.deleteFile(fileId);
    }
}
