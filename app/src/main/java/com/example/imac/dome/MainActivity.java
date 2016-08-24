package com.example.imac.dome;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private ViewPager viewPager;
    private List<Fragment> lists;
    private WebView web;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);
        web = (WebView) findViewById(R.id.web);
        textView = (TextView) findViewById(R.id.bulld);
//        web.setWebViewClient(new WebViewClient());
//        web.loadUrl("file:///android_res/raw/telsms.html");
        textView.setText(Arrays.toString(Build.SUPPORTED_ABIS));

//        viewPager = (ViewPager) findViewById(R.id.viewpager);
//        lists = new ArrayList<>();
//        lists.add(new MyFragment());
//        lists.add(new MyFragment());
//        lists.add(new MyFragment());
//        lists.add(new MyFragment());
//        lists.add(new MyFragment());
//        FragementPagerView fragementPagerView = new FragementPagerView(getSupportFragmentManager(), lists);
//        viewPager.setAdapter(fragementPagerView);
//        viewPager.setPageTransformer(false, new DepthPageTransformer());
//        viewPager.setCurrentItem(1);

    }
}
