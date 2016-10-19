package com.feicui.everyproject.http;

/**
 * 处理请求数据的接口
 * Created by Eric on 2016/3/30.
 */
public interface RequestResult {

    /**
     * 用于处理 请求成功
     * */
    public void onRequestSuccess();

    /**
     * 用于处理 请求失败
     * */
    public void onRequestFaild();

    /**
     * 用于处理操作成功
     * */
    public void onHandleSuccess(int requestCode);

    /**
     * 用于处理操作失败
     * */
    public void onHandleFaild(Message message);

    /**
     * 用于处理网络无连接
     * */
    public void onNoConnect();

}
