package com.example.imac.myview.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

/**
 * Created by liqingju on 16/8/22.
 */
public class CrileView extends View implements Runnable {
    private boolean isRun = true;
    private int angle = 100;
    int height;
    int width;
    Canvas canvas;
    float lineX = 0;
    Paint paint1 = new Paint();
    private float leftCric = 200;
    private float rightCric = 0;
    private float criRodus = 20;
    private final float huan = 200;
    private float chanzhi = 0;
    private ValueAnimator leftPointAnimator = ObjectAnimator.ofFloat(this, "leftCric", 0f, 400f);
    private ValueAnimator rightPointAnimator = ObjectAnimator.ofFloat(this, "leftCric", 400f, 0f);
    private AnimatorSet mAnimatorSet = new AnimatorSet();

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            angle = (int) (Math.random() * 100);
            angle += 20;

//            leftPointAnimator.setCurrentPlayTime((long) (5000.0F * 1));
//            postInvalidate();

//            invalidate();
//            mHandler.sendEmptyMessageDelayed(1, 2000);
        }
    };

    public CrileView(Context context) {
        super(context);
        initAno();
    }

    public CrileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAno();
    }

    public CrileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAno();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(7);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(leftCric, Math.abs(chanzhi - getRightCric()), criRodus, paint);
        canvas.drawCircle(200, 200, huan, paint);
        Path path = new Path();
        path.moveTo(0, 400);
        path.lineTo(400, 400);
        path.lineTo(400, 0);
        path.moveTo(0, 200);
        path.lineTo(400, 200);
        path.moveTo(200, 200);
        path.lineTo(leftCric, Math.abs(chanzhi - getRightCric()));
        canvas.drawPath(path, paint);
        Log.e("=====", leftCric + "   " + getRightCric());
        if (!mAnimatorSet.isRunning()) {
            mAnimatorSet.start();
        }
    }

    void initAno() {
        mAnimatorSet.setDuration(5000L);
        leftPointAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                chanzhi = huan * 2;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        rightPointAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                chanzhi = 0;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        mAnimatorSet.playSequentially(leftPointAnimator, rightPointAnimator);
//        mAnimatorSet.setInterpolator(new CycleInterpolator(2));
    }


    /**
     * 绘制动态的 view
     */
    public void drawAnnorSin(Canvas canvas) {
        this.canvas = canvas;
        height = getHeight();
        width = getWidth();
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(5);
//        paint1.setAlpha(100);
        paint1.setColor(Color.BLACK);
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, paint1);
        canvas.drawLine(100, 0, 100, getHeight(), paint1);
        Paint textPaint = new Paint();
        textPaint.setStrokeWidth(10);
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(30);
        textPaint.setAntiAlias(true);
        paint1.setColor(Color.RED);
        canvas.drawText("0", 120, getHeight() / 2 - 20, textPaint);
        for (int i = 100; i < getWidth(); i++) {
            lineX = i;
            double lineY2 = 100 * Math.sin((2 * i + angle) * Math.PI / 180) + 100;
            canvas.drawLine((int) i, (int) (lineY2 + height / 2), (int) i + 2, (int) (lineY2 + height / 2), paint1);
        }
        mHandler.sendEmptyMessageDelayed(1, 50);
    }


    /**
     * 按照角度绘制位置
     *
     * @param canvas
     */
    void drawArc(Canvas canvas) {
        Paint paint = new Paint();
        Path path = new Path();
        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(0, getHeight() / 2);
        path.lineTo(getWidth(), getHeight() / 2);
        path.moveTo(getWidth() / 2, 0);
        path.lineTo(getWidth() / 2, getHeight());
        path.moveTo(getWidth() / 2, getHeight());
        path.addCircle(getWidth() / 2, getHeight() / 2, 100, Path.Direction.CW);
        path.moveTo(getWidth() / 2 + (float) (100 * Math.cos(Math.PI / 4)), getHeight() / 2 - (float) (100 * Math.sin(Math.PI / 4)));
        path.lineTo(getWidth() / 2 + (float) (80 * Math.cos(Math.PI / 4)), getHeight() / 2 - (float) (80 * Math.sin(Math.PI / 4)));
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLUE);
        canvas.drawPath(path, paint);
    }

    /**
     * 绘制 圆环
     *
     * @param canvas
     */
    void initClire(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 30, paint);
        paint.setColor(Color.WHITE);
//        paint.setAlpha(0);
        paint.setAntiAlias(true);
//        paint.setColor();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 25, paint);
    }

    @Override
    public void run() {
        while (isRun) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            angle = (int) (Math.random() * 100);

            invalidate();
        }
    }


    public float getLeftCric() {
//        Log.e("=====", "111222");
        return leftCric;
    }

    public void setLeftCric(float leftCric) {
        this.leftCric = leftCric;
//        Log.e("=====", "111");
        postInvalidate();
    }


    public float getRightCric() {
        return (float) (Math.sqrt(Math.pow(huan, 2) - Math.pow(getLeftCric() - 200, 2)) + 200);
    }

    public void setRightCric(float rightCric) {
        this.rightCric = rightCric;
    }
}
