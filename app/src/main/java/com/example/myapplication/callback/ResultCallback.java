package com.example.myapplication.callback;

import com.example.myapplication.bean.NewBean;

import java.util.List;

public interface ResultCallback {
    void onSuccess(List<NewBean.RecentBean> list);
    void onFail(String str);
}
