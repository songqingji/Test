package com.feicui.everyproject.util;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理json的工具包
 * Created by Eric on 2016/9/22.
 */
public class JsonUtil {

    private static Gson gson = new Gson();

    /**
     * 获取  属性值
     * */
    public static String getValue(String jsonStr,String key){
        String value = null;
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            value = jsonObject.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return value;
    }

    /**
     * 获取json字符串 中的对象
     * */
    public static JSONObject getJsonObject(String jsonStr,String key){
        JSONObject jsonObject = null;
        JSONObject object = null;
        try {
            jsonObject = new JSONObject(jsonStr);
            object = jsonObject.getJSONObject(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 获取json字符串 中的数组
     * */
    public static JSONArray getJsonArray(String jsonStr,String key){
        JSONObject jsonObject = null;
        JSONArray array = null;
        try {
            jsonObject = new JSONObject(jsonStr);
            array = jsonObject.getJSONArray(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return array;
    }

    /**
     * gson字符串转换成实体
     * */
    public static <T> T getEntityFromGson(String gsonString, Class<T> cls) {
        T t = gson.fromJson(gsonString, cls);
        return t;
    }

    /**
     *  gson转化为列表
     * */
    public static <T> List<T> getListFromGson(String gsonString, Class<T> cls) {
        List<T> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(gsonString);
            for(int i = 0 ; i < jsonArray.length() ; i ++){
                JSONObject object = jsonArray.getJSONObject(i);
                T t = gson.fromJson(object.toString(), cls);
                list.add(t);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //if (gson != null) {
        //    list = gson.fromJson(gsonString, new TypeToken<List<T>>() {}.getType());
        //}
        return list;
    }



}
