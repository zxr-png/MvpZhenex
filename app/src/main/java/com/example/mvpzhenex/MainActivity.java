package com.example.mvpzhenex;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvpzhenex.contrae.MainContrate;
import com.example.mvpzhenex.persenter.MainPersenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainPersenter> implements MainContrate.ListView {

    private Banner banner;
    private RecyclerView recy;
    private ArrayList<ListBean.NewsDTO> list;
    private RecyAdapter adapter;


    @Override
    protected void initData() {
        MainPersenter persenter = new MainPersenter (this);
        persenter.List ();
    }

    public void initView() {
        banner = (Banner) findViewById (R.id.banner);
        recy = (RecyclerView) findViewById (R.id.recy);
        recy.setLayoutManager (new LinearLayoutManager (this));
        list = new ArrayList<> ();
        adapter = new RecyAdapter (this, list);
        recy.setAdapter (adapter);
    }

    @Override
    protected int getlayout() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPersenter add() {
        return new MainPersenter (this);
    }

    @Override
    public void onListbanner(ListBean listBean) {
        List<ListBean.NewsDTO> news = listBean.getNews ();
        banner.setImages (news).setImageLoader (new ImageLoader () {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ListBean.NewsDTO lis= (ListBean.NewsDTO) path;
                Glide.with (context).load (lis.getImageUrl ()).into (imageView);
            }
        }).start ();
        list.addAll (news);
        adapter.notifyDataSetChanged ();
    }
}