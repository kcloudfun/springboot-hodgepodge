package com.record.hodgepodge.controller;

import com.record.hodgepodge.pojo.TestPojo;
import com.record.hodgepodge.service.ITranTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tran")
public class TransactionTestController {

    @Autowired
    private ITranTestService tranTestService;

    @PostMapping("/query")
    public List<TestPojo> queryTestDatas() {
        return tranTestService.getTestDatas();
    }

    @PostMapping("/tran1")
    public void tranTest1() {
        tranTestService.normalScene();
    }

    @PostMapping("/tran2")
    public void tranTest2() {
        tranTestService.multiMethod();
    }
}
