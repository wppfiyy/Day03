package com.example.day03.presenter;

import com.example.day03.Ben.MyBen;
import com.example.day03.base.BasePresenter;
import com.example.day03.utils.net.URLConstans;
import com.example.day03.constart.MyConstart;
import com.example.day03.model.MyModel;
import com.example.day03.utils.net.MyCallBack;

public class MyPresenter extends BasePresenter<MyConstart.MyView> implements MyConstart.MyPresenter {

    private MyConstart.MyModel myModel;
    public MyPresenter(MyConstart.MyView myView){
        myModel=new MyModel(this);
    }

    @Override
    public void initPP() {
        myModel.getLoginData(URLConstans.NEWLIST, new MyCallBack<MyBen>() {
            @Override
            public void onSuccess(MyBen myBen) {
                iView.onSuccess(myBen);
            }

            @Override
            public void onFail(String error) {

            }
        });
    }
}
