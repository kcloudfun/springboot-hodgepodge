package com.record.hodgepodge.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("T_UPLOAD_RECORD")
public class UploadRecord {

    /**
     * 文件id
     */
    @TableId("FILE_ID")
    private String fileId;

    /**
     * 存储全路径
     */
    @TableField("PATH")
    private String path;

    /**
     * 原文件名
     */
    @TableField("ORIGINAL_NAME")
    private String originalName;

    /**
     * 上传时间
     */
    @TableField("UPLOAD_TIME")
    private Date uploadTime;

    /**
     * 上传人
     */
    @TableField("UPLOAD_BY")
    private String uploadBy;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadBy() {
        return uploadBy;
    }

    public void setUploadBy(String uploadBy) {
        this.uploadBy = uploadBy;
    }

    @Override
    public String toString() {
        return "UploadRecord{" +
                "fileId='" + fileId + '\'' +
                ", path='" + path + '\'' +
                ", originalName='" + originalName + '\'' +
                ", uploadTime=" + uploadTime +
                ", uploadBy='" + uploadBy + '\'' +
                '}';
    }
}
