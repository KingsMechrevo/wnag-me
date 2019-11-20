package com.example.myapplication.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapters.HomeAdapter;
import com.example.myapplication.apsp.SqlApplication;
import com.example.myapplication.bean.CollectBean;
import com.example.myapplication.dp.CollectBeanDao;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectFragment extends Fragment {


    public CollectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collect, container, false);
//        CollectBeanDao beanDao = SqlApplication.getInstance().getDaoSession().getCollectBeanDao();
//        List<CollectBean> beans = beanDao.loadAll();
//        initView(view);
        return view;
    }

    private void initView(View view) {
//        recy = view.findViewById(R.id.recy);
//        recy.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recy.addItemDecoration(new DividerItemDecoration(getActivity(), 1));
//
//        beans = new ArrayList<>();
//        adapter = new HomeAdapter(getActivity(), beans);
    }
}
