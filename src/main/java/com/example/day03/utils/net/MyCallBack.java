package com.example.day03.utils.net;

public interface MyCallBack<T> {
    void onSuccess(T t);
    void onFail(String error);
}
