package com.example.day03.persenter;

import com.example.day03.ApiService.Apisercive;
import com.example.day03.Constrat.MainContrat;
import com.example.day03.Net.ImNetWorkCallback;
import com.example.day03.Net.UrlContrat;
import com.example.day03.base.BasePersenter;
import com.example.day03.bean.NewBeans;
import com.example.day03.modle.ModleIm;

public class PersenterIm extends BasePersenter<MainContrat.IMainView> implements MainContrat.IMainPersenter {

    private MainContrat.IMainModle mainModle;

    public PersenterIm( MainContrat.IMainView mainView) {
        this.mainModle = new ModleIm(this);
    }

    @Override
    public void Perget(String result) {
        mainModle.getData(UrlContrat.NEWLIST, new ImNetWorkCallback<NewBeans>() {
            @Override
            public void onSuccess(NewBeans beans) {
               iView.Vwget(beans);
            }

            @Override
            public void onFail(String error) {

            }
        });
    }
}
