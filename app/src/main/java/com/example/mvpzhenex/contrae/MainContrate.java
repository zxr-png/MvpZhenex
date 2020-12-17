package com.example.mvpzhenex.contrae;

import com.example.mvpzhenex.ListBean;
import com.example.mvpzhenex.util.CallBackList;

public class MainContrate {
    public interface ListView{
        void onListbanner(ListBean listBean);
    }
    public interface ListPersenter{
        void List();
    }
    public interface ListModel{
        <T> void ListModel(String url, CallBackList<T> callBackList);
    }
}
