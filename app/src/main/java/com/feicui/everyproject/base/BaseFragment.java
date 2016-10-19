package com.feicui.everyproject.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.feicui.everyproject.R;
import com.feicui.everyproject.http.Message;
import com.feicui.everyproject.http.RequestResult;
import com.feicui.everyproject.widget.dialog.CustomProgressDialog;

/**
 * 基础  fragment
 * Created by Eric on 2016/9/28.
 */
public class BaseFragment extends Fragment  implements RequestResult {

    private int requestCode;
    private Message message;

    private int CODE_REQUEST_SUCCESS = 0;
    private int CODE_REQUEST_FAILED = 1;
    private int CODE_HANDLE_SUCCESS = 2;
    private int CODE_HANDLE_FAILED = 3;
    private int CODE_NO_CONNECT = 4;

    @Override
    public void onRequestSuccess() {
        handler.sendEmptyMessage(CODE_REQUEST_SUCCESS);
    }

    @Override
    public void onRequestFaild() {
        handler.sendEmptyMessage(CODE_REQUEST_FAILED);
    }

    @Override
    public void onHandleSuccess(int requestCode) {
        this.requestCode = requestCode;
        handler.sendEmptyMessage(CODE_HANDLE_SUCCESS);
    }

    @Override
    public void onHandleFaild(Message message) {
        this.message = message;
        handler.sendEmptyMessage(CODE_HANDLE_FAILED);
    }

    @Override
    public void onNoConnect() {
        Log.d("demo", "activity中 请求失败");
        handler.sendEmptyMessage(CODE_NO_CONNECT);
    }


    Handler handler = new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {

            if(msg.what == CODE_REQUEST_SUCCESS){
                onRequestSuccess2();
            }

            if(msg.what == CODE_REQUEST_FAILED){
                onRequestFaild2();
            }

            if(msg.what == CODE_HANDLE_SUCCESS){
                onHandleSuccess2(requestCode);
            }

            if(msg.what == CODE_HANDLE_FAILED){
                onHandleFaild2(message);
            }

            if(msg.what == CODE_NO_CONNECT){
                onNoConnect2();
            }


        }
    };

    public void onRequestSuccess2() {

    }

    public void onRequestFaild2() {
        Toast.makeText(getActivity(), "数据异常", Toast.LENGTH_LONG).show();
    }

    public void onHandleSuccess2(int requestCode) {
        showProgress(false);
    }

    public void onHandleFaild2(Message message) {
        showProgress(false);
    }

    public void onNoConnect2() {
        showProgress(false);
        Toast.makeText(getActivity(), "网络异常", Toast.LENGTH_LONG).show();
    }

    CustomProgressDialog progressDialog;

    public void showProgress(boolean show,boolean cancleFlg) {
        if (show) {
            progressDialog = CustomProgressDialog.showProgress(getActivity(),cancleFlg);
        } else {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
    }

    public void showProgress(boolean show) {
        if (show) {
            showProgress(true,false);
        } else {
            showProgress(false,false);
        }
    }

}
