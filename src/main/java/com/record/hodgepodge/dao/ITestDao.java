package com.record.hodgepodge.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.record.hodgepodge.pojo.TestPojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITestDao extends BaseMapper<TestPojo> {

    int errorInsert();
}
