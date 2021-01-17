package com.record.hodgepodge.service.impl;

import com.record.hodgepodge.dao.IUploadRecordDao;
import com.record.hodgepodge.pojo.UploadRecord;
import com.record.hodgepodge.service.IFileHandleService;
import com.record.hodgepodge.pojo.CommonResult;
import com.record.hodgepodge.util.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FileHandleServiceImpl implements IFileHandleService {

    private final static String targetFilePath = "D://test//";

    @Autowired(required = false)
    private IUploadRecordDao uploadRecordDao;

    /**
     * 文件上传（多个）
     *
     * @param files
     * @return
     * @throws Exception
     */
    @Override
    public CommonResult<List<String>> batchUpload(List<MultipartFile> files) throws Exception {
        CommonResult<List<String>> uploadResult = new CommonResult<>();
        if (CollectionUtils.isEmpty(files)) {
            uploadResult.setMsg("目标文件列表为空！");
            return uploadResult;
        }
        List<String> fileIds = new ArrayList<>();
        for (MultipartFile file : files) {
            fileIds.add(doUpload(file));
        }
        uploadResult.setData(fileIds);
        return uploadResult;
    }

    /**
     * 文件上传（单个）
     *
     * @param file
     * @return
     */
    @Override
    public CommonResult<String> upload(MultipartFile file) throws Exception {
        CommonResult<String> uploadResult = new CommonResult<>();
        if (file.isEmpty()) {
            uploadResult.setMsg("目标文件为空！");
            return uploadResult;
        }
        uploadResult.setData(doUpload(file));
        return uploadResult;
    }

    /**
     * 处理文件上传
     *
     * @param file
     * @return
     * @throws Exception
     */
    private String doUpload(MultipartFile file) throws Exception {
        String originalFilename = file.getOriginalFilename();
        //后缀
        String suffix = originalFilename.split("\\.")[1];
        //生成唯一编号
        String fileId = KeyUtil.getUUID();
        //拼接服务器全路径
        String fullPath = targetFilePath + fileId + "." + suffix;
        UploadRecord uploadRecord = new UploadRecord();
        uploadRecord.setFileId(fileId);
        uploadRecord.setOriginalName(originalFilename);
        uploadRecord.setPath(fullPath);
        uploadRecord.setUploadTime(new Date());
        //插入一条上传记录
        uploadRecordDao.insert(uploadRecord);
        File newFile = new File(fullPath);
        //调用springMVC封装的io方法写入文件
        file.transferTo(newFile);
        return fileId;
    }

    /**
     * 根据文件id下载已上传的文件
     *
     * @param response
     * @param fileId
     */
    @Override
    public void download(HttpServletResponse response, String fileId) {
        UploadRecord uploadRecord = uploadRecordDao.selectById(fileId);
        if (uploadRecord == null) {
            return;
        }
        response.setHeader("content-disposition", "attachment;filename=" + uploadRecord.getOriginalName());
        File file = new File(uploadRecord.getPath());
        //jdk1.7以后新特性，这样写编译器会帮助生成关闭资源代码
        try (FileInputStream fileInputStream = new FileInputStream(file); ServletOutputStream outputStream = response.getOutputStream()) {
            byte[] bytes = new byte[1024 * 8];
            int readBytes = 0;
            while ((readBytes = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, readBytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据文件id删除已上传的文件
     *
     * @param fileId
     * @return
     */
    @Override
    public CommonResult<Boolean> deleteFile(String fileId) {
        CommonResult<Boolean> deleteResult = new CommonResult<>();
        UploadRecord uploadRecord = uploadRecordDao.selectById(fileId);
        if (uploadRecord == null) {
            deleteResult.setMsg("fileId有误！");
            return deleteResult;
        }
        File file = new File(uploadRecord.getPath());
        if (!file.exists()) {
            deleteResult.setMsg("数据异常！");
            return deleteResult;
        }
        file.delete();
        uploadRecordDao.deleteById(fileId);
        deleteResult.setData(true);
        return deleteResult;
    }

}
