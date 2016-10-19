package com.feicui.everyproject.http;

/**
 * 消息状态
 * Created by Eric on 2016/3/30.
 */
public class Message {

    private String code;//返回码
    private String message;//返回信息

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
