package com.example.mvpzhenex.persenter;

import com.example.mvpzhenex.ListBean;
import com.example.mvpzhenex.Model.MainModel;
import com.example.mvpzhenex.contrae.MainContrate;
import com.example.mvpzhenex.util.CallBackList;
import com.example.mvpzhenex.util.Url;

public class MainPersenter extends BasePrensert implements MainContrate.ListPersenter {

    private MainContrate.ListModel model;
    private MainContrate.ListView view;

    public MainPersenter(MainContrate.ListView view) {
        this.view = view;
        model=new MainModel (this);
    }

    @Override
    public void List() {
        model.ListModel (Url.ListUrl, new CallBackList<ListBean> () {
            @Override
            public void onSecced(ListBean listBean) {
                view.onListbanner (listBean);
            }

            @Override
            public void onFiale(Error error) {

            }
        });
    }
}
