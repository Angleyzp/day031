package com.example.day03;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day03.Constrat.MainContrat;
import com.example.day03.adapter.RcAdapter;
import com.example.day03.bean.NewBeans;
import com.example.day03.persenter.PersenterIm;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContrat.IMainView {


    private RecyclerView recy;
    private ArrayList<NewBeans.NewsDTO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        initView();
        initData();
    }

    private void initData() {
        PersenterIm persenterIm = new PersenterIm(this);
        persenterIm.Perget("请求成功");
    }

    private void initView() {
        recy = (RecyclerView) findViewById(R.id.recy);
    }
    @Override
    public void Vwget(NewBeans beans) {
        List<NewBeans.NewsDTO> news = beans.getNews();
        list.addAll(news);
        recy.setLayoutManager(new LinearLayoutManager(this));
        RcAdapter rcAdapter = new RcAdapter(this,list);
        recy.setAdapter(rcAdapter);
    }
}