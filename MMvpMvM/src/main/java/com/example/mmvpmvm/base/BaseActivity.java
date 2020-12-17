package com.example.mmvpmvm.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T extends BasePrenter> extends AppCompatActivity implements BaseView{
    public T Iprenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        if (Iprenter==null){
            Iprenter=getPrenter();
            Iprenter.addACter(this);
        }
        initView();
        initDatas();
    }

    protected abstract void initDatas();
    protected abstract void initView();
    protected abstract int getView();
    protected abstract T getPrenter();;
}
