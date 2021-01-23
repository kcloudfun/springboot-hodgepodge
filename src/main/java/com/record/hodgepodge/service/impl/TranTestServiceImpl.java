package com.record.hodgepodge.service.impl;

import com.record.hodgepodge.dao.ITestDao;
import com.record.hodgepodge.pojo.TestPojo;
import com.record.hodgepodge.service.ITranTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TranTestServiceImpl implements ITranTestService {

    @Autowired
    private ITestDao testDao;

    /**
     * 查询表数据
     *
     * @return
     */
    @Override
    public List<TestPojo> getTestDatas() {
        return testDao.selectList(null);
    }

    /**
     * 一般的事务场景（正常触发事务）
     */
    @Override
    @Transactional
    public void normalScene() {
        TestPojo testPojo = new TestPojo();
        testPojo.setField1("很少很少");
        testDao.insert(testPojo);
        //springboot事务开启只需加一行注解，前面本插入成功，但由于下面失败所以前面也会被回滚掉
        testDao.errorInsert();
    }

    /**
     * 多层次方法调用时（正常触发事务）
     */
    @Override
    @Transactional
    public void multiMethod() {
        insert1();
        //整个方法加事务之后就能保证整个方法是一个事务，即使内部有调用多个方法
        insert2();
    }

    private void insert1() {
        TestPojo testPojo = new TestPojo();
        testPojo.setField1("很少很少");
        testDao.insert(testPojo);
    }

    private void insert2() {
        testDao.errorInsert();
    }
}
