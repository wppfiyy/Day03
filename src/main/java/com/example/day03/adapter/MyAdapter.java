package com.example.day03.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day03.Ben.MyBen;
import com.example.day03.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<MyBen.NewsBean> list;

    public MyAdapter(Context context, ArrayList<MyBen.NewsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.img_item, parent, false);
        return new ImgViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyBen.NewsBean newsBean = list.get(position);
        ImgViewHolder imgViewHolder= (ImgViewHolder) holder;
        imgViewHolder.tv.setText(newsBean.getTile());
        Glide.with(context).load(newsBean.getImageUrl()).into(imgViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ImgViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;

        public ImgViewHolder(View root) {
            super(root);
            img=root.findViewById(R.id.img);
            tv=root.findViewById(R.id.tv);
        }
    }
}
