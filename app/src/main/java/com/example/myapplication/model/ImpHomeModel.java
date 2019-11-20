package com.example.myapplication.model;

import com.example.myapplication.api.Apiservice;
import com.example.myapplication.bean.NewBean;
import com.example.myapplication.callback.ResultCallback;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpHomeModel implements HomeModel{

    @Override
    public void getNew(final ResultCallback resultCallback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Apiservice.baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Apiservice apiservice = retrofit.create(Apiservice.class);
        Observable<NewBean> observable = apiservice.getBean();
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewBean newBean) {
                        List<NewBean.RecentBean> list = newBean.getRecent();
                        resultCallback.onSuccess(list);
                    }

                    @Override
                    public void onError(Throwable e) {
                        resultCallback.onFail("数据请求错误"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
