package com.feicui.everyproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
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
public class TestActivity  extends BaseActivity {

    @BindView(R.id.pullToRefreshListView)
    PullToRefreshListView pullToRefreshListView;

    private List<TestEntity> listEntity = null;
    private TestDao testDao = null;
    private TestAdapter testAdapter = null;

    private String TITLE = "测试标题";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        ButterKnife.bind(this);

        //模式: 上拉下拉都可以
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        listEntity = new ArrayList<>();
        testAdapter = new TestAdapter(getApplicationContext(),listEntity);
        pullToRefreshListView.setAdapter(testAdapter);

        testDao = new TestDao(this);
        showProgress(true);
        testDao.postRequestInfo("shehui","d8c3088fb695fae5a6e5951a2d6473c0");

    }

    @Override
    public void onHandleSuccess2(int requestCode) {
        showProgress(false);
        //上拉或者下拉  数据加载完成后  把加载的动画效果 关闭
        pullToRefreshListView.onRefreshComplete();

        if(requestCode ==  1){
            List<TestEntity> list = testDao.getListNews();
            listEntity.addAll(list);
            testAdapter.setList(listEntity);
            testAdapter.notifyDataSetChanged();

            pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                @Override
                public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                    //Toast.makeText(getApplicationContext(),"下拉",Toast.LENGTH_LONG).show();
                    listEntity.clear();
                    testDao.postRequestInfo("shehui", "d8c3088fb695fae5a6e5951a2d6473c0");
                }

                @Override
                public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                    //Toast.makeText(getApplicationContext(),"上拉",Toast.LENGTH_LONG).show();
                    testDao.postRequestInfo("shehui", "d8c3088fb695fae5a6e5951a2d6473c0");
                }
            });
        }



    }

    @Override
    public void onHandleFaild2(com.feicui.everyproject.http.Message message) {
        showProgress(false);
        //上拉或者下拉  数据加载完成后  把加载的动画效果 关闭
        pullToRefreshListView.onRefreshComplete();
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
                Intent intent = new Intent(TestActivity.this, Test2Activity.class);
                startActivity(intent);
            }
        });

        return true;
    }

}
