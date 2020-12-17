package com.example.day03.modle;

import com.example.day03.Constrat.MainContrat;
import com.example.day03.Net.ImNetWorkCallback;
import com.example.day03.Net.RetrofitUtils;

public class ModleIm implements MainContrat.IMainModle {

    private MainContrat.IMainPersenter persenter;

    public ModleIm(MainContrat.IMainPersenter persenter) {
        this.persenter = persenter;
    }

    @Override
    public <T> void getData(String url, ImNetWorkCallback<T> callback) {
        RetrofitUtils.getRetrofitUtils().get(url,callback);
    }
}
