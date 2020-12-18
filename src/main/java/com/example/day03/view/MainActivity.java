package com.example.day03.view;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day03.Ben.MyBen;
import com.example.day03.R;
import com.example.day03.adapter.MyAdapter;
import com.example.day03.base.BaseActivity;
import com.example.day03.constart.MyConstart;
import com.example.day03.presenter.MyPresenter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MyPresenter> implements MyConstart.MyView {
    private RecyclerView mRecycler;
    private ArrayList<MyBen.NewsBean> list;
    private MyAdapter myAdapter;


    @Override
    protected void initView() {
        mRecycler=findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        mRecycler.setAdapter(myAdapter);
    }

    @Override
    protected void initData() {
        pp.initPP();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public MyPresenter getPp() {
        return new MyPresenter(this);
    }

    @Override
    public void onSuccess(MyBen myBen) {
        list.addAll(myBen.getNews());
        myAdapter.notifyDataSetChanged();
    }
}