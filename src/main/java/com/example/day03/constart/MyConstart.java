package com.example.day03.constart;

import com.example.day03.Ben.MyBen;
import com.example.day03.base.BaseView;
import com.example.day03.utils.net.MyCallBack;

public class MyConstart {
    public interface MyView extends BaseView {

        void onSuccess(MyBen myBen);
    }
    public interface MyPresenter{

        void initPP();
    }
    public interface MyModel{


        <T>void getLoginData(String newlist, MyCallBack<T> myBenMyCallBack);

    }
}
