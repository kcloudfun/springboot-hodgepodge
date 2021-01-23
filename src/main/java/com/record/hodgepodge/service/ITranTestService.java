package com.record.hodgepodge.service;

import com.record.hodgepodge.pojo.TestPojo;

import java.util.List;

public interface ITranTestService {

    /**
     * 查询表数据
     *
     * @return
     */
    List<TestPojo> getTestDatas();

    /**
     * 一般的事务场景（正常触发事务）
     */
    void normalScene();

    /**
     * 多层次方法调用时（正常触发事务）
     */
    void multiMethod();
}
