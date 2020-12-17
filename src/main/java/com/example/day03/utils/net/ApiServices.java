package com.example.day03.net;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiServices {
    @GET
    Observable<ResponseBody> getData(@Url String url);

}
