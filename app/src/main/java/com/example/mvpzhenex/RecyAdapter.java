package com.example.mvpzhenex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<ListBean.NewsDTO> list;


    public RecyAdapter(Context context, ArrayList<ListBean.NewsDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from (context).inflate (R.layout.item, parent, false);
        return new ViewHilder (inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHilder hilder= (ViewHilder) holder;
        hilder.txtDesc.setText (list.get (position).getTile ());
//        Glide.with (context).load (list.get (position).getImageUrl ()).into (hilder.imgItem);
        Glide.with (context).load (list.get (position).getImageUrl ()).into (hilder.imgItem);
    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

   class ViewHilder extends RecyclerView.ViewHolder {

       private ImageView imgItem;
       private TextView txtDesc;
       public ViewHilder(@NonNull View itemView) {
           super (itemView);
           imgItem = itemView.findViewById (R.id.img_item);
           txtDesc = itemView.findViewById (R.id.txt_desc);
       }
   }
}
