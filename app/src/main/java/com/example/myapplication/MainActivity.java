package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.adapters.FmAdapter;
import com.example.myapplication.fragments.CollectFragment;
import com.example.myapplication.fragments.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new CollectFragment());
        ArrayList<String> title = new ArrayList<>();
        title.add("首页");
        title.add("收藏");
        FmAdapter adapter = new FmAdapter(getSupportFragmentManager(), list, title);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);


    }
}
