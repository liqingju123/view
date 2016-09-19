package com.example.imac.myview.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.imac.myview.R;

/**
 * Created by liqingju on 16/9/9.
 */
public class ViewActivity extends Activity implements View.OnClickListener {

    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        performAnimate();
    }

    private void performAnimate() {
        ViewWrapper wrapper = new ViewWrapper(mButton);
        ObjectAnimator.ofInt(wrapper, "width", 9000).start();
    }


    private static class ViewWrapper {
        private View mTarget;

        public ViewWrapper(View target) {
            mTarget = target;
        }

        public int getWidth() {
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width) {
            Log.e("=====", width + "   ");
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }
    }

}
