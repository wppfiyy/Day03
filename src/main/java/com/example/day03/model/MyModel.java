package com.example.day03.model;

import com.example.day03.utils.net.RetifitUtils;
import com.example.day03.constart.MyConstart;
import com.example.day03.utils.net.MyCallBack;
import com.example.day03.presenter.MyPresenter;

public class MyModel implements MyConstart.MyModel {
    private MyPresenter myPresenter;

    public MyModel(MyPresenter myPresenter) {

        this.myPresenter = myPresenter;
    }

    @Override
    public <T> void getLoginData(String newlist, MyCallBack<T> myBenMyCallBack) {
        RetifitUtils.getInstance().getData(newlist,myBenMyCallBack);
    }
}
