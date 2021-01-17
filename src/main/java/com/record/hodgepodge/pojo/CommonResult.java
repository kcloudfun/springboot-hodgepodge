package com.record.hodgepodge.pojo;

import io.swagger.annotations.ApiModelProperty;

public class CommonResult<T> {

    @ApiModelProperty(value = "响应码值")
    private String code;

    @ApiModelProperty(value = "响应描述性信息")
    private String msg;

    @ApiModelProperty(value = "响应数据")
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
