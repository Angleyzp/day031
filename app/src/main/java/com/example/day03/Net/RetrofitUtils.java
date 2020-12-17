package com.example.day03.Net;

import com.example.day03.ApiService.Apisercive;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtils implements ImNetWorkInterfece{
   private static RetrofitUtils retrofitUtils;
    private final Apisercive apisercive;


    private RetrofitUtils() {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(UrlContrat.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apisercive = retrofit.create(Apisercive.class);
    }

    public static RetrofitUtils getRetrofitUtils() {
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    @Override
    public <T> void get(String url, ImNetWorkCallback<T> callback) {
                apisercive.get(url)
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
                                    Type[] types = callback.getClass().getGenericInterfaces();
                                    Type[] typeArguments = ((ParameterizedType)types[0]).getActualTypeArguments();
                                    Type t = typeArguments[0];
                                    T result = new Gson().fromJson(string, t);
                                    callback.onSuccess(result);
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
