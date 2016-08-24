package com.example.imac.dome;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by imac on 16/4/29.
 */
public class DepthPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;

    @Override
    public void transformPage(View page, float position) {


        int pageWidth = page.getWidth();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            // view.setAlpha(0);
            ViewHelper.setAlpha(page, 0);
            ViewHelper.setPivotX(page, page.getMeasuredHeight() / 2);
            ViewHelper.setPivotY(page, page.getMeasuredWidth() / 2);
            ViewHelper.setScaleX(page, 1);
            ViewHelper.setScaleY(page, MIN_SCALE);
        } else if (position <= 0)// a页滑动至b页 ； a页从 0.0 -1 ；b页从1 ~ 0.0
        { // [-1,0]

            ViewHelper.setPivotX(page, page.getMeasuredHeight() / 2);
            ViewHelper.setPivotY(page, page.getMeasuredWidth() / 2);
            ViewHelper.setScaleX(page, 1);
            ViewHelper.setScaleY(page, 1f + (position) * 0.25f);


            // Use the default slide transition when moving to the left page
            // view.setAlpha(1);
//            ViewHelper.setAlpha(page, 1);
            // view.setTranslationX(0);
//            ViewHelper.setTranslationX(page, 0);
            // view.setScaleX(1);
//            ViewHelper.setScaleX(page, 1);
            // view.setScaleY(1);
//            ViewHelper.setScaleY(page, 1);



        } else if (position <= 1) { // (0,1]
            ViewHelper.setPivotX(page, page.getMeasuredHeight() / 2);
            ViewHelper.setPivotY(page, page.getMeasuredWidth() / 2);
            ViewHelper.setScaleX(page, 1);
            ViewHelper.setScaleY(page, 1f - ((position) * 0.25f));


            // Fade the page out.
            // view.setAlpha(1 - position);
//            ViewHelper.setAlpha(page, 1 - position);

            // Counteract the default slide transition
            // view.setTranslationX(pageWidth * -position);
//            ViewHelper.setTranslationX(page, pageWidth * -position);

            // Scale the page down (between MIN_SCALE and 1)
//            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - position);
            // view.setScaleX(scaleFactor);
//            ViewHelper.setScaleX(page, scaleFactor);
            // view.setScaleY(1);
//            ViewHelper.setScaleY(page, scaleFactor);

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            // view.setAlpha(0);
            ViewHelper.setPivotX(page, page.getMeasuredHeight() / 2);
            ViewHelper.setPivotY(page, page.getMeasuredWidth() / 2);
            ViewHelper.setScaleX(page, 1);
            ViewHelper.setScaleY(page, MIN_SCALE);
        }

    }
}
