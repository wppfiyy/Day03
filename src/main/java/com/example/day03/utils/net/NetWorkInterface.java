package com.example.day03.utils.net;

public interface NetWorkInterface {
    public <T> void getData(String url,MyCallBack<T> myCallBack);
}
