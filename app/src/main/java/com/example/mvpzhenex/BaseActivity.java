package com.example.mvpzhenex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mvpzhenex.persenter.BasePrensert;
import com.example.mvpzhenex.util.BaseView;

public abstract class BaseActivity<T extends BasePrensert> extends AppCompatActivity implements BaseView{

    public T t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (getlayout ());

        if (t==null){
            t=add ();
            t.addView (this);
        }

        initData ();
        initView ();
    }
    protected abstract void initData();
    protected abstract void initView();
    protected abstract int getlayout();
    protected abstract T add();
}