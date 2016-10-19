package com.feicui.everyproject.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.feicui.everyproject.R;

/**
 * 所有activity的基类
 * Created by Eric on 2016/9/12.
 */
public class BaseToolbarActivity extends AppCompatActivity {

    private Toolbar mToolbar = null;
    private ImageView mLeftBtn = null;
    private TextView mTitle = null;
    private ImageView mRightBtn = null;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        getToolbar();
    }

    private Toolbar getToolbar(){
        if(mToolbar == null){
            mToolbar = (Toolbar)findViewById(R.id.toolbar);
            mToolbar.setTitle("");
            mToolbar.setContentInsetsAbsolute(0,0);
            mLeftBtn = (ImageView)findViewById(R.id.leftBtn_iv);
            mTitle = (TextView)findViewById(R.id.title_tv);
            mRightBtn = (ImageView)findViewById(R.id.rightBtn_iv);
            setSupportActionBar(mToolbar);
        }
        return mToolbar;
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(setTitle() == null){
            mTitle.setVisibility(View.GONE);
        } else {
            mTitle.setText(setTitle());
            mTitle.setVisibility(View.VISIBLE);
        }

        if(mLeftBtn != null){
           if(setLeftBtn(mLeftBtn)){
               mLeftBtn.setVisibility(View.VISIBLE);
           } else {
               mLeftBtn.setVisibility(View.GONE);
           }
        }

        if(mRightBtn != null){
            if(setRightBtn(mRightBtn)){
                mRightBtn.setVisibility(View.VISIBLE);
            } else {
                mRightBtn.setVisibility(View.GONE);
            }
        }

    }

    public String setTitle(){
        return null;
    }

    public boolean setLeftBtn(ImageView mLeftBtn){
        return false;
    }

    public boolean setRightBtn(ImageView mRightBtn){
        return false;
    }


}
