package com.example.day03.base;

public class BasePersenter<V extends BaseView> {
    public V iView;

    public void attachView(V v){
        iView=v;
    }

}
