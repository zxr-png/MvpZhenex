package com.example.mmvpmvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.example.mmvpmvm.R;
import com.example.mmvpmvm.base.BaseActivity;
import com.example.mmvpmvm.bean.NewsBaen;
import com.example.mmvpmvm.contract.IMyMain;
import com.example.mmvpmvm.prenter.MainPrenter;

import java.util.List;

public class MainActivity extends BaseActivity<MainPrenter> implements IMyMain.Iview {


    private TextView tv;

    @Override
    protected void initDatas() {
        Iprenter.getNews();
    }

    @Override
    protected void initView() {
        tv = findViewById(R.id.tv);
    }

    @Override
    protected int getView() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPrenter getPrenter() {
        return new MainPrenter();
    }

    @Override
    public void getNews(NewsBaen newsBaen) {
        List<NewsBaen.NewsDTO> news = newsBaen.getNews();
        tv.setText(news.get(0).getTile());
    }
}