package com.feicui.everyproject.http;

import android.util.Log;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * 网络请求 封装类
 * Created by Eric on 2016/9/23.
 */
public abstract class RequestClient {

    /**数据请求结果  接口*/
    public RequestResult mResult;

    /**创建okHttpClient对象*/
    private static OkHttpClient okHttpClient = new OkHttpClient();

    /**
     * 构造方法
     * 参数: requestResult
     * */
    public RequestClient(RequestResult requestResult){
        this.mResult = requestResult;
    }

    /**
     * 抽象方法, 用于处理 数据返回成功
     * */
    public abstract void handleSuccess(JSONObject jsonObject,int requestCode);

    /**
     * get方式请求数据
     * */
    public void getRequest(final String url,final int requestCode){

        //新建一个请求
        Request request = new Request.Builder()
                .url(url)
                .build();

        //获取一个响应
        Call call = okHttpClient.newCall(request);

        //响应的回调
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {
                Log.d("demo", "client中 请求失败");
                mResult.onNoConnect();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                //Log.d("demo","请求成功");
                String jsonStr = response.body().string();
                Log.d("demo", "client中请求成功: " + jsonStr);

                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    String code = jsonObject.getString("error_code");
                    String reason = jsonObject.getString("reason");
                    Log.d("demo", "client中code: " + code);

                    if(code.equals("0")){
                        handleSuccess(jsonObject,requestCode);
                        mResult.onHandleSuccess(requestCode);
                    } else {
                        Message message = new Message();
                        message.setCode(code);
                        message.setMessage(reason);
                        mResult.onHandleFaild(message);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    mResult.onRequestFaild();
                }

            }
        });
    }

    /**
     * post方式请求数据
     * */
    public void postRequest(final String url,final RequestBody formBody,final int requestCode){

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        //获取一个响应
        Call call = okHttpClient.newCall(request);

        //响应的回调
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {
                Log.d("demo", "client中 请求失败");
                mResult.onNoConnect();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                //Log.d("demo","请求成功");
                String jsonStr = response.body().string();
                Log.d("demo", "client中请求成功: " + jsonStr);

                try {
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    String code = jsonObject.getString("error_code");
                    String reason = jsonObject.getString("reason");
                    Log.d("demo", "client中code: " + code);

                    if(code.equals("0")){
                        handleSuccess(jsonObject,requestCode);
                        mResult.onHandleSuccess(requestCode);
                    } else {
                        Message message = new Message();
                        message.setCode(code);
                        message.setMessage(reason);
                        mResult.onHandleFaild(message);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    mResult.onRequestFaild();
                }

            }
        });
    }





}
