package com.example.myapplication.parsent;

import com.example.myapplication.bean.NewBean;
import com.example.myapplication.callback.ResultCallback;
import com.example.myapplication.model.ImpHomeModel;
import com.example.myapplication.views.ResultView;

import java.util.List;

public class ImpHomeParsent implements HomeParsent, ResultCallback {
    private ResultView resultView;
    private ImpHomeModel impHomeModel;

    public ImpHomeParsent(ResultView resultView) {
        this.resultView = resultView;
        impHomeModel=new ImpHomeModel();
    }

    @Override
    public void getNew() {
        impHomeModel.getNew(this);
    }

    @Override
    public void onSuccess(List<NewBean.RecentBean> list) {
        resultView.onSuccess(list);
    }

    @Override
    public void onFail(String str) {
        resultView.onFail(str);
    }
}
