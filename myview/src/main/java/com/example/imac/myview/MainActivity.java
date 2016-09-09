package com.example.imac.myview;

import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.imac.myview.activity.ActivityA;
import com.example.imac.myview.activity.ViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mActivityButton;
    private Button mActivityAnnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivityButton = (Button) findViewById(R.id.activity_ann);
        mActivityAnnButton = (Button) findViewById(R.id.activity_view);
        mActivityButton.setOnClickListener(this);
        mActivityAnnButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.activity_view:
                Intent intent = new Intent(this, ActivityA.class);
                startActivity(intent);
                break;
            case R.id.activity_ann:
                intent = new Intent(this, ViewActivity.class);
                startActivity(intent);
                break;
        }


    }


}
