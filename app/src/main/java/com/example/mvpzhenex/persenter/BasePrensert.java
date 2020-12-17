package com.example.mvpzhenex.persenter;

import com.example.mvpzhenex.util.BaseView;

public class BasePrensert <T extends BaseView>{
    public T view;
    public void addView(T t){
        view=t;
    }
}
