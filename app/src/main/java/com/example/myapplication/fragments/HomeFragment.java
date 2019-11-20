package com.example.myapplication.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapters.HomeAdapter;
import com.example.myapplication.apsp.SqlApplication;
import com.example.myapplication.bean.CollectBean;
import com.example.myapplication.bean.NewBean;
import com.example.myapplication.dp.CollectBeanDao;
import com.example.myapplication.parsent.ImpHomeParsent;
import com.example.myapplication.views.ResultView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements ResultView {


    private RecyclerView recy;
    private ArrayList<NewBean.RecentBean> beans;
    private HomeAdapter adapter;
    private CollectBeanDao beanDao;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        beanDao = SqlApplication.getInstance().getDaoSession().getCollectBeanDao();
        ImpHomeParsent impHomeParsent = new ImpHomeParsent(this);
        impHomeParsent.getNew();
        initData();
        return view;
    }

    private void initData() {
        recy.setAdapter(adapter);
        adapter.setOnClickListener(new HomeAdapter.OnClickListener() {
            @Override
            public void myClick(int pos) {
                Intent intent = new Intent(getActivity(), WebView.class);
                intent.putExtra("url", beans.get(pos).getUrl());
                startActivity(intent);
            }

            @Override
            public void mylongClick(int pos) {
                CollectBean bean = new CollectBean();
                bean.setPic(beans.get(pos).getThumbnail());
                bean.setTitle(beans.get(pos).getTitle());
                bean.setUrl(beans.get(pos).getUrl());
                beanDao.insertOrReplace(bean);
                Toast.makeText(getContext(), "收藏成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View view) {
        recy = view.findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        recy.addItemDecoration(new DividerItemDecoration(getActivity(), 1));

        beans = new ArrayList<>();
        adapter = new HomeAdapter(getActivity(), beans);
    }

    @Override
    public void onSuccess(List<NewBean.RecentBean> list) {
        beans.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }
}
