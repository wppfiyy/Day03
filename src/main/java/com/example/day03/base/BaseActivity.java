package com.example.day03.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {
    public T pp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        if(pp==null){
            pp=getPp();
            pp.attachView(this);
        }
        initData();
        initView();
    }

    protected abstract void initView();
    protected abstract void initData();
    protected abstract int getLayoutID();
    public abstract   T getPp();
}
