package com.example.mvpzhenex.Model;

import com.example.mvpzhenex.contrae.MainContrate;
import com.example.mvpzhenex.util.CallBackList;
import com.example.mvpzhenex.util.RetortInterface;

public class MainModel implements MainContrate.ListModel{
    private MainContrate.ListPersenter persenter;


    public MainModel(MainContrate.ListPersenter persenter) {
        this.persenter = persenter;
    }

    @Override
    public <T> void ListModel(String url, CallBackList<T> callBackList) {
        RetortInterface.getRetortInterface ().get (url,callBackList);
    }
}
