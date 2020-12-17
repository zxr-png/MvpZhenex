package com.example.mmvpmvm.prenter;


import com.example.mmvpmvm.base.BasePrenter;
import com.example.mmvpmvm.bean.NewsBaen;
import com.example.mmvpmvm.contract.ICallBack;
import com.example.mmvpmvm.contract.IMyMain;
import com.example.mmvpmvm.model.MainModel;
import com.example.mmvpmvm.utils.MyUel;

public class MainPrenter extends BasePrenter<IMyMain.Iview> implements IMyMain.Iprenter {
    public IMyMain.Imodel imodel;

    public MainPrenter() {
        this.imodel = new MainModel ();
    }

    @Override
    public void getNews() {
        imodel.getNews(MyUel.NEWL_URL, new ICallBack<NewsBaen> () {
            @Override
            public void getSuccess(NewsBaen newsBaen) {
                Iview.getNews(newsBaen);
            }

            @Override
            public void getFails() {

            }
        });
    }
}
