package com.example.day03.net;

public interface NetWorkInterface {
    public <T> void getData(String url,MyCallBack<T> myCallBack);
}
