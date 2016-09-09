package com.example.imac.myview.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.example.imac.myview.R;


public class ActivityA extends Activity {

    ViewGroup viewGroup;
    View blueButton;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Transition exitTrans = new Explode();
//        getWindow().setExitTransition(exitTrans);
//
//        Transition reenterTrans = new Slide();
//        reenterTrans.setDuration(3000);
//        ((Slide) reenterTrans).setSlideEdge(Gravity.RIGHT);
//        getWindow().setReenterTransition(reenterTrans);

        setContentView(R.layout.activity_a);

        viewGroup = (ViewGroup) findViewById(R.id.main_layout);
        viewGroup.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ActivityA.this);
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                startActivity(intent, options.toBundle());
            }
        });

    }

}
