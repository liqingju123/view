package com.example.imac.dome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by imac on 16/4/29.
 */
public class MyFragment extends Fragment {
    View page;
    private int flag;



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        page = getView().findViewById(R.id.img);
//        page.setBackgroundResource(flag);
//        ViewHelper.setPivotX(page, page.getMeasuredHeight() / 2);
//        ViewHelper.setPivotY(page, page.getMeasuredWidth() / 2);
//        ViewHelper.setScaleX(page, 1);
//        ViewHelper.setScaleY(page, 0.5f);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.myfragment, null);
    }
}
