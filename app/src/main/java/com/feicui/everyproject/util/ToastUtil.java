package com.feicui.everyproject.util;

import android.content.Context;
import android.widget.Toast;

/**
 * 吐司 工具类
 * Created by Eric on 2016/9/28.
 */
public class ToastUtil {

    /**静态变量  吐司*/
    private static Toast toast ;

    /**显示短时间 Toast*/
    public static void showShortToast(Context context, String message){
        if(toast != null){
            toast.cancel();
        }
        toast = Toast.makeText(context,message,Toast.LENGTH_SHORT);
        toast.show();
    }

    /**显示长时间 Toast*/
    public static void showLongToast(Context context, String message){
        if(toast != null){
            toast.cancel();
        }
        toast = Toast.makeText(context,message,Toast.LENGTH_LONG);
        toast.show();
    }

}
