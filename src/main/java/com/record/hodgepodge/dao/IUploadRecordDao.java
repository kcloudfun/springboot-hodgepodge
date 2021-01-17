package com.record.hodgepodge.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.record.hodgepodge.pojo.UploadRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUploadRecordDao extends BaseMapper<UploadRecord> {

}
