package com.example.mmvpmvm.contract;


import com.example.mmvpmvm.base.BaseView;
import com.example.mmvpmvm.bean.NewsBaen;

public interface IMyMain {

    interface Imodel{
        <T> void getNews(String url, ICallBack<T> callBack);
    }
    interface Iprenter{
        void getNews();
    }
    interface Iview extends BaseView {
        void getNews(NewsBaen newsBaen);
    }
}
