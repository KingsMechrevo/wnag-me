package com.example.myapplication.api;

import com.example.myapplication.bean.NewBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Apiservice {
    //http://news-at.zhihu.com/api/4/news/hot
    String baseurl="http://news-at.zhihu.com";
    @GET("api/4/news/hot")
    Observable<NewBean> getBean();

}
