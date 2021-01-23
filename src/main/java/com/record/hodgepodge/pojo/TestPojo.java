package com.record.hodgepodge.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("T_TEST")
public class TestPojo {

    @TableField("FIELD1")
    private String field1;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    @Override
    public String toString() {
        return "TestPojo{" +
                "field1='" + field1 + '\'' +
                '}';
    }
}
