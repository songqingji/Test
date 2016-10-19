package com.feicui.everyproject.dao;

import android.util.Log;

import com.feicui.everyproject.base.Constant;
import com.feicui.everyproject.entity.TestEntity;
import com.feicui.everyproject.http.RequestClient;
import com.feicui.everyproject.http.RequestResult;
import com.feicui.everyproject.util.JsonUtil;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

import org.json.JSONObject;

import java.util.List;

/**
 * Main2类中所有请求数据的动作
 * Created by Eric on 2016/9/23.
 */
public class TestDao extends RequestClient {


    private String message;

    private List<TestEntity> listEntity = null;

    /**
     * 构造方法
     * 参数: requestResult
     * @param requestResult
     */
    public TestDao(RequestResult requestResult) {
        super(requestResult);
    }

    /**
     * 测试  get方式请求数据的方法
     * */
    public void getRequestInfo(){
        getRequest(Constant.BASE_URL_GET, 0);
    }

    /**
     * 测试  post方式请求数据的方法
     * */
    public void postRequestInfo(String type,String key){

        RequestBody params = new FormEncodingBuilder()
                .add("type", type)
                .add("key", key)
                .build();
        postRequest(Constant.BASE_URL_POST,params,1);

    }

    @Override
    public void handleSuccess(JSONObject jsonObject, int requestCode) {

        Log.d("demo","requestCode: " + requestCode);
        Log.d("demo","jsonObject: " + jsonObject.toString());

        if(requestCode == 0){
            message = JsonUtil.getValue(jsonObject.toString(), "reason");
        }

        if(requestCode == 1){
            //message = JsonUtil.getValue(jsonObject.toString(),"reason");
            listEntity = JsonUtil.getListFromGson(JsonUtil.getJsonArray((JsonUtil.getJsonObject(jsonObject.toString(),"result").toString()),"data").toString(),TestEntity.class);
        }

    }

    public String getMessage() {
        return message;
    }

    public List<TestEntity> getListNews() {
        return listEntity;
    }
}





