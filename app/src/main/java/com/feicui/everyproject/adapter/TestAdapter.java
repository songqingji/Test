package com.feicui.everyproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.feicui.everyproject.R;
import com.feicui.everyproject.entity.TestEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
public class TestAdapter extends BaseAdapter {

    private Context context = null;
    private List<TestEntity> list = null;
    private LayoutInflater inflater = null;

    public TestAdapter(Context context, List<TestEntity> list){
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        notifyDataSetChanged();
    }

    public void setList(List<TestEntity> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if(convertView != null){
            view = convertView;
        } else {
            view = inflater.inflate(R.layout.item,null);
        }

        TextView name_tv = (TextView)view.findViewById(R.id.name_tv);

        TestEntity entity = list.get(position);

        name_tv.setText(position + entity.getTitle());

        return view;
    }



    static class ViewHolder{

        TextView name_tv;

    }


}
