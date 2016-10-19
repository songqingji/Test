package com.feicui.everyproject.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.feicui.everyproject.R;
import com.feicui.everyproject.adapter.TestAdapter;
import com.feicui.everyproject.base.BaseActivity;
import com.feicui.everyproject.base.BaseToolbarActivity;
import com.feicui.everyproject.dao.TestDao;
import com.feicui.everyproject.entity.TestEntity;
import com.feicui.everyproject.util.ToastUtil;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 测试跳转activity
 * Created by Eric on 2016/9/28.
 */
public class Test2Activity extends BaseActivity {

    private String TITLE = "测试标题2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_activity);

    }

    @Override
    public String setTitle() {
        return TITLE;
    }

    @Override
    public boolean setLeftBtn(ImageView mLeftBtn) {

        mLeftBtn.setImageResource(R.drawable.btn_homeasup_default);
        mLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        return true;
    }

    @Override
    public boolean setRightBtn(ImageView mRightBtn) {

        mRightBtn.setImageResource(R.drawable.accept_blue);
        mRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showLongToast(getApplicationContext(), "XXXXXX");
            }
        });

        return true;
    }

}
