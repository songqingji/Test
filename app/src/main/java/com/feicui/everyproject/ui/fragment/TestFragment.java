package com.feicui.everyproject.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.feicui.everyproject.R;
import com.feicui.everyproject.adapter.TestAdapter;
import com.feicui.everyproject.base.BaseFragment;
import com.feicui.everyproject.dao.TestDao;
import com.feicui.everyproject.entity.TestEntity;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 测试  fragment
 * Created by Eric on 2016/9/28.
 */
public class TestFragment extends BaseFragment {

    @BindView(R.id.pullToRefreshListView)
    PullToRefreshListView pullToRefreshListView;

    private List<TestEntity> listEntity = null;
    private TestDao testDao = null;
    private TestAdapter testAdapter = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        //模式: 上拉下拉都可以
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        listEntity = new ArrayList<>();
        testAdapter = new TestAdapter(getActivity(),listEntity);
        pullToRefreshListView.setAdapter(testAdapter);

        testDao = new TestDao(this);
        showProgress(true);
        testDao.postRequestInfo("shehui", "d8c3088fb695fae5a6e5951a2d6473c0");
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




}
