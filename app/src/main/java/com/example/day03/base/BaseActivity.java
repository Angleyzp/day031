package com.example.day03.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity <P extends BasePersenter> extends AppCompatActivity implements BaseView{

        public P persenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        if (persenter==null){
            persenter = add();
            persenter.attachView(this);
        }

        initView();
        initData();
    }

    protected abstract void initData();


    protected abstract void initView();


    protected abstract int getLayoutID();


    public abstract P add();
}
