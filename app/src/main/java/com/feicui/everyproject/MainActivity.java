package com.feicui.everyproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.feicui.everyproject.base.BaseActivity;
import com.feicui.everyproject.base.BaseToolbarActivity;
import com.feicui.everyproject.ui.TestActivity;
import com.feicui.everyproject.util.ToastUtil;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.text_btn)
    TextView text_btn;
    @BindView(R.id.image_iv)
    ImageView image_iv;

    private String TITLE = "标题啊标题";

    private String imageUrl = "https://p1.ssl.qhimg.com/t01d4e10d4dcb331fd8.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        text_btn.setOnClickListener(this);

        Picasso.with(this).load(imageUrl).into(image_iv);

    }

    @Override
    public void onClick(View v) {
        if(v == text_btn){
            Intent intent = new Intent(MainActivity.this, TestActivity.class);
            startActivity(intent);
        }
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
                //ToastUtil.showLongToast(getApplicationContext(),"XXXXXX");
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });

        return true;
    }
}
