package com.example.imac.dome;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by imac on 16/4/29.
 */
public class FragementPagerView extends FragmentStatePagerAdapter {
    private List<Fragment> lists;

    public FragementPagerView(FragmentManager fm, List<Fragment> lists) {
        super(fm);
        this.lists = lists;
    }

    @Override
    public Fragment getItem(int position) {
        return lists.get(position);
    }


    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public float getPageWidth(int position) {
        return 0.9f;
    }
}
