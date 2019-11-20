package com.example.myapplication.views;

import com.example.myapplication.bean.NewBean;

import java.util.List;

public interface ResultView {
    void onSuccess(List<NewBean.RecentBean> list);
    void onFail(String str);
}
