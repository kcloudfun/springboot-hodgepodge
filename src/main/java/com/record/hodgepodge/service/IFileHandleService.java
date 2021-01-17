package com.record.hodgepodge.service;

import com.record.hodgepodge.pojo.CommonResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IFileHandleService {

    /**
     * 文件上传（多个）
     *
     * @param files
     * @return
     * @throws Exception
     */
    CommonResult<List<String>> batchUpload(List<MultipartFile> files) throws Exception;

    /**
     * 文件上传（单个）
     *
     * @param file
     * @return
     */
    CommonResult<String> upload(MultipartFile file) throws Exception;

    /**
     * 根据文件id下载已上传的文件
     *
     * @param response
     * @param fileId
     */
    void download(HttpServletResponse response, String fileId);

    /**
     * 根据文件id删除已上传的文件
     *
     * @param fileId
     * @return
     */
    CommonResult<Boolean> deleteFile(String fileId);
}
