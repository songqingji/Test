package com.feicui.everyproject.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.feicui.everyproject.R;

/**
 * 自定义 加载框
 * Created by Eric on 2016/9/25.
 */
public class CustomProgressDialog extends Dialog {

    public CustomProgressDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static CustomProgressDialog showProgress(Context context,boolean cancleAble){

        //获取加载器
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //加载dialog对应的布局文件
        View view = inflater.inflate(R.layout.custom_progress_dialog,null);
        //实例化一个CustomProgressDialog
        CustomProgressDialog dialog = new CustomProgressDialog(context, R.style.Dialog);
        //把页面导入当前的dialog
        dialog.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //设置  是否可以取消
        dialog.setCancelable(cancleAble);

        //加载图片
        ImageView progress_iv = (ImageView)view.findViewById(R.id.progress_iv);
        //获取到背景动画
        AnimationDrawable ad = (AnimationDrawable)progress_iv.getBackground();
        //启动动画
        ad.start();
        //显示 弹框
        dialog.show();

        return dialog;
    }




}
