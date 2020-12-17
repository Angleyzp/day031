package com.example.day03.Constrat;

import com.example.day03.Net.ImNetWorkCallback;
import com.example.day03.base.BaseView;
import com.example.day03.bean.NewBeans;

public class MainContrat {
        public interface  IMainModle {
            <T> void getData(String url, ImNetWorkCallback<T> callback);
        }

        public interface IMainPersenter{
            void Perget(String result);
        }
        public interface IMainView extends BaseView{
            void Vwget(NewBeans beans);
        }
}
