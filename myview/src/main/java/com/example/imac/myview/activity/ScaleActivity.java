package com.example.imac.myview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.example.imac.myview.R;

/**
 * Created by liqingju on 16/9/19.
 */
public class ScaleActivity extends Activity {
    private LinearLayout ll_root;
    private float lastY;
    private float diffY;
    private float diffXY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);
        ll_root = (LinearLayout) findViewById(R.id.root);
        ll_root.post(new Runnable() {
            @Override
            public void run() {
                ll_root.setPivotX(ll_root.getX());
                ll_root.setPivotY(ll_root.getY() / 2);
                diffXY = ll_root.getWidth() / ll_root.getHeight();
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (lastY == 0) {
                    lastY = event.getY();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                diffY = event.getY() - lastY;
                float withH = diffY / ll_root.getHeight();
                Log.e("=====", withH + "     " + withH);
                withH = withH < 0 ? 1.0f : withH;
                ll_root.setScaleX(withH);
                ll_root.setScaleY(withH);
//                ll_root.scrollBy(0, (int) withH);
                break;
            case MotionEvent.ACTION_UP:
                lastY = event.getY();
                break;
        }

        return true;
    }
}
