package com.example.day03.base;

import com.example.day03.net.ApiServices;
import com.example.day03.net.MyCallBack;
import com.example.day03.net.NetWorkInterface;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetifitUtils implements NetWorkInterface {


    private static ApiServices apiServices;
    private static RetifitUtils retifitUtils;


    private RetifitUtils(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConstans.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiServices = retrofit.create(ApiServices.class);
    }

    public static RetifitUtils getInstance(){
        if(retifitUtils==null){
            synchronized (RetifitUtils.class){
                if(retifitUtils==null){
                    retifitUtils=new RetifitUtils();
                }
            }
        }
        return retifitUtils;
    }

    @Override
    public <T> void getData(String url, MyCallBack<T> myCallBack) {
        apiServices.getData(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = myCallBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();

                            Type type=actualTypeArguments[0];

                            Gson gson = new Gson();
                            T result = gson.fromJson(string, type);
                            myCallBack.onSuccess(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
