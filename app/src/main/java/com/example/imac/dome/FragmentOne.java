package com.example.imac.dome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imac on 16/4/29.
 */
public class FragmentOne extends Fragment implements ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private List<Fragment> lists;
    private RelativeLayout root;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewPager = (ViewPager) getView().findViewById(R.id.viewpager);
        root = (RelativeLayout) getView().findViewById(R.id.root);
        viewPager.setClipToPadding(false);
        lists = new ArrayList<>();
//        lists.add(new MyFragment(R.drawable.about));
//        lists.add(new MyFragment(R.drawable.about));
//        lists.add(new MyFragment(R.drawable.about));
//        lists.add(new MyFragment(R.drawable.about));
//        lists.add(new MyFragment(R.drawable.about));
        FragementPagerView fragementPagerView = new FragementPagerView(getActivity().getSupportFragmentManager(), lists);
        viewPager.setAdapter(fragementPagerView);
        getView().post(new Runnable() {
            @Override
            public void run() {
                int w = getView().getWidth();
                viewPager.setPadding((int) (w * 0.125), 0, (int) (w * 0.05), 0);
                // 25% padding on either side so pages takes exactly 50% space
            }
        });
//        viewPager.setPageTransformer(false, new DepthPageTransformer());
//        viewPager.setCurrentItem(1);
        viewPager.addOnPageChangeListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_main, null);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
//        viewPager.setCurrentItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
