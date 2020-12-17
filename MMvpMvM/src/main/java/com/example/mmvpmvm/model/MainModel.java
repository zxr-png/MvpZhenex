package com.example.mmvpmvm.model;


import com.example.mmvpmvm.contract.ICallBack;
import com.example.mmvpmvm.contract.IMyMain;
import com.example.mmvpmvm.utils.MyNetworkframework;

public class MainModel implements IMyMain.Imodel {
    @Override
    public <T> void getNews(String url, ICallBack<T> callBack) {
        MyNetworkframework.getInstance().get(url,callBack);
    }
}
