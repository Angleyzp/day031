package com.example.day03.ApiService;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Apisercive {
    @GET
    Observable<ResponseBody> get(@Url String url);

}
