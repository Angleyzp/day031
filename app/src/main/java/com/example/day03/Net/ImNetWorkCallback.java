package com.example.day03.Net;

public interface ImNetWorkCallback<T> {
    public void onSuccess(T t);
    public void onFail(String error);
}
