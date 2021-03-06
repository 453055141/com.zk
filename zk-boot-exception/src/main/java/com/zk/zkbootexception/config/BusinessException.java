package com.zk.zkbootexception.config;

/**
 * 自定义异常
 */
public class BusinessException extends RuntimeException {

    private Integer code;
    private String msg;

    public BusinessException(String msg){
        super(msg);
        this.msg = msg;
    }

    public BusinessException(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
